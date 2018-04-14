package com.tw;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 此类存储单个学生信息,id相同认为是同一个学生
 */
public class Student {

    private String name;

    private long id;

    //成绩有四门语文，数学，英语，编程
    private TreeMap<CourseEnum, Double> grades;

    private Double totalGrade;

    public Student(){};
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, long id, TreeMap<CourseEnum, Double> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((Student)obj).getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TreeMap<CourseEnum, Double> getGrades() {
        return grades;
    }

    public void setGrades(TreeMap<CourseEnum, Double> grades) {
        this.grades = grades;
    }

    public Double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }
}
