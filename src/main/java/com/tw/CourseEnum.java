package com.tw;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public enum CourseEnum implements Comparable<CourseEnum>{

    MATHS("数学", 1),
    CHINESE("语文", 2),
    ENGLISH("英语", 3),
    PROGRAMMING("编程", 4),
    UNKNOWN("未知", 5),
    ;
    private String courseName;

    private Integer CourseID;

    CourseEnum(String courseName, Integer courseID) {
        this.courseName = courseName;
        CourseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseID() {
        return CourseID;
    }

    public static CourseEnum resolve(String courseName) {
        if (INSTANCE.containsKey(courseName)) {
            return INSTANCE.get(courseName);
        }
        return CourseEnum.UNKNOWN;
    }

    private static final Map<String, CourseEnum> INSTANCE = new HashMap<>();

    static {
        CourseEnum[] values = CourseEnum.values();
        for (CourseEnum value : values) {
            if (value == UNKNOWN) {
                continue;
            }
            INSTANCE.put(value.getCourseName(), value);
        }
    }

    public static int getCourseEnumNumber() {
        return INSTANCE.size();
    }


}
