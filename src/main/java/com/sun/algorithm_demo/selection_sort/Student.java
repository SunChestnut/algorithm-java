package com.sun.algorithm_demo.selection_sort;

import lombok.Data;

/**
 * 学生实体类，用于排序测试
 *
 * @author syl
 * @date 2020/01/07 - 16:18
 */
@Data
public class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    /**
     * 如果分数相等，则按照名字的字母序排序,如果分数不等，则分数高的靠前
     *
     * @param o Student
     * @return int
     */
    @Override
    public int compareTo(Student o) {
        if (this.score < o.score) {
            return -1;
        } else if (this.score > o.score) {
            return 1;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}
