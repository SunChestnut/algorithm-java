# 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。

# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+

# 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

# +---------------------+
# | SecondHighestSalary |
# +---------------------+
# | 200                 |
# +---------------------+

CREATE TABLE IF NOT EXISTS Employee
(
    Id     INT,
    Salary INT
);

#---------------------------------------------------------
INSERT INTO Employee
VALUES (1, 100),
       (2, 200),
       (3, 300);

# the first method , 不推荐

SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (
    SELECT MAX(Salary)
    FROM Employee
);

# the second method
# offset M : 跳过M条记录，默认 M = 0
# limit N,M : 相当于 limit M offset N , 从第N条记录开始，返回M条数据

# 当没有第二高的工资时，这条sql返回值为空
SELECT DISTINCT Salary AS SecondHighestSalary
FROM Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1;

# 将其作为临时表，改成如下sql，可解决上述问题
SELECT (
           SELECT DISTINCT Salary
           FROM Employee
           ORDER BY Salary DESC
           LIMIT 1 OFFSET 1
       ) AS SecondHighestSalary;

# 还可通过 IFNULL(expr1,expr2) 函数解决上述问题
SELECT IFNULL(
               (
                   SELECT Salary
                   FROM Employee
                   LIMIT 1 OFFSET 1
               ),
               NULL
           ) AS SecondHighestSalary;
