### **SQL Tutorial: How To Write Better Queries**

#### **Learn about anti-patterns, execution plans, time complexity, query tuning, and optimization in SQL. **

Structured Query Language (SQL) is an indispensable skill in the data science industry and generally speaking, learning this skill is relatively straightforward. However, most forget that SQL isn’t just about writing queries, which is just the first step down the road. Ensuring that queries are performant or that they fit the context that you’re working in is a whole other thing.

That’s why this SQL tutorial will provide you with a small peek at some steps that you can go through to evaluate your query:

- First off, you’ll start with a short overview of the [importance of learning SQL](https://www.datacamp.com/community/tutorials/sql-tutorial-query#importance) for jobs in data science;

- Next, you’ll first learn more about how [SQL query processing and execution](https://www.datacamp.com/community/tutorials/sql-tutorial-query#execution) so that you can adequately understand the importance of writing qualitative queries: more specifically, you’ll see that the query is parsed, rewritten, optimized and finally evaluated;

- With that in mind, you’ll not only go over some [query anti-patterns](https://www.datacamp.com/community/tutorials/sql-tutorial-query#antipattern) that beginners make when writing queries, but you’ll also learn more about alternatives and solutions to those possible mistakes; You’ll also learn more about the [set-based versus the procedural approach](https://www.datacamp.com/community/tutorials/sql-tutorial-query#setbased) to querying.

- You’ll also see that these anti-patterns stem from performance concerns and that, besides the “manual” approach to improving SQL queries, you can [analyze your queries](https://www.datacamp.com/community/tutorials/sql-tutorial-query#queryplan) also in a more structured, in-depth way by making use of some other tools that help you to see the query plan; And,

- You’ll briefly go more into [time complexity and the big O notation](https://www.datacamp.com/community/tutorials/sql-tutorial-query#bigo) to get an idea about the time complexity of an execution plan before you execute your query; Lastly,

- You'll briefly get some pointers on how you can [tune your query](https://www.datacamp.com/community/tutorials/sql-tutorial-query#tune) further.

  ![content_pexels-photo-325229](D:\Documents\logPicture\content_pexels-photo-325229.jpg)

Are you interested in an SQL course? Take DataCamp’s [Intro to SQL for Data Science](https://www.datacamp.com/courses/intro-to-sql-for-data-science) course!

#### **Why Should I Learn SQL For Data Science? **

SQL is far from dead: it’s one of the most in-demand skills that you find in job descriptions from the data science industry, whether you’re applying for a data analyst, a data engineer, a data scientist or [any other roles](https://www.datacamp.com/community/tutorials/data-science-industry-infographic). This is confirmed by 70% of the respondents of the 2016 O’Reilly Data Science Salary Survey, who indicate that they use SQL in their professional context. What’s more, in this survey, SQL stands out way above the R (57%) and Python (54%) programming languages.

You get the picture: SQL is a must-have skill when you’re working towards getting a job in the data science industry.

Not bad for a language that was developed in the early 1970s, right?

But why exactly is it that it is so frequently used? And why isn’t it dead even though it has been around for such a long time?

There are several reasons: one of the first reasons would be that companies mostly store data in Relational Database Management Systems (RDBMS) or in Relational Data Stream Management Systems (RDSMS) and you need SQL to access that data. SQL is the lingua franca of data: it gives you the ability to interact with almost any database or even to build your own locally!

As if this wasn’t enough yet, keep in mind that there are quite a few SQL implementations that are incompatible between vendors and do not necessarily follow standards. Knowing the standard SQL is thus a requirement for you to find your way around in the (data science) industry.

On top of that, it’s safe to say that SQL has also been embraced by newer technologies, such as Hive, a SQL-like query language interface to query and manage large datasets, or Spark SQL, which you can use to execute SQL queries. Once again, the SQL that you find there will differ from the standard that you might have learned, but the learning curve will be considerably easier.

If you do want to make a comparison, consider it as learning linear algebra: by putting all that effort into this one subject, you know that you will be able to use it to master machine learning as well!

In short, this is why you should learn this query language:

- It’s is fairly easy to learn, even for total newbies. The learning curve is quite easy and gradual, so you’ll be writing queries in no time.

- It follows the “learn once, use anywhere” principle, so it’s a great investment of your time!

- It’s an excellent addition to programming languages; In some cases, writing a query is even preferred over writing code because it’s more performant!

- ...

What are you still waiting for? :)

### **SQL Processing & Query Execution**

To improve the performance of your SQL query, you first have to know what happens internally when you press the shortcut to run the query.

First, the query is parsed into a “parse tree”; The query is analyzed to see if it satisfies the syntactical and semantical requirements. The parser creates an internal representation of the input query. This output is then passed on to the rewrite engine.

It is then the task of the optimizer to find the optimal execution or query plan for the given query. The execution plan defines exactly what algorithm is used for each operation, and how the execution of the operations is coordinated.

To indeed find the most optimal execution plan, the optimizer enumerates all possible execution plans, determines the quality or cost of each plan, takes information about the current database state and then chooses the best one as the final execution plan. Because query optimizers can be imperfect, database users and administrators sometimes need to manually examine and tune the plans produced by the optimizer to get better performance.

Now you probably wonder what is considered to be a “good query plan”.



  