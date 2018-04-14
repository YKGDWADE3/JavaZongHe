package com.tw;

import java.util.HashMap;

/**
 * 此类存储单个学生信息,id相同认为是同一个学生
 */
public class Student {

    private String name;

    private long id;

    //成绩有四门语文，数学，英语，编程
    private HashMap<CourseEnum, Double> grades;

    public Student(){};
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, long id, HashMap<CourseEnum, Double> grades) {
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

    public HashMap<CourseEnum, Double> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<CourseEnum, Double> grades) {
        this.grades = grades;
    }
}
