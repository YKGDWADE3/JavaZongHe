package com.tw;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Library {
    String mString = "杨开广, 12345, 数学: 98, 英语: 88.12, 语文: 87.2, 编程: 89";

    private static final String NAME_VAILD= "[\u4e00-\u9fa5]{2,4}";
    private static final String ID_VAILD= "^[1-9]\\d{1,9}$";
    private static final String GRADE_VAILD= "^[+]?([0-9]+(.[0-9]{1,2})?)$";

    public static void main(String[] args ) {
        Scanner input = new Scanner(System.in);
        HashSet<Student> students = new HashSet<>();

        while (true) {
            println(GlobalConstants.MAIN_PAGE);
            String cmdLine = input.nextLine();

            if (cmdLine.equals("1")) {
                println(GlobalConstants.CHOOSE_1);
                while (true) {
                    String addStudentString = input.nextLine();
                    if (!addStudentSuccess(addStudentString, students)) {
                        println(GlobalConstants.ADD_STU_FAIL);
                    }else{
                        break;
                    }
                }
            } else if (cmdLine.equals("2")) {

            } else if (cmdLine.equals("3")) {
                System.exit(0);
            } else {

            }
        }
    }

    private static boolean addStudentSuccess(String studentString, HashSet<Student> studentHashSet) {
        if (!studentString.isEmpty()){
            Student student = new Student();
            String[] strings = studentString.replaceAll(" ", "").split(",");
            if (strings.length == 6) {
                //name
                if (strings[0].matches(NAME_VAILD)) {
                    student.setName(strings[0]);
                }else{
                    return false;
                }
                //id
                if (strings[1].matches(ID_VAILD)) {
                    student.setId(Long.parseLong(strings[1]));
                } else {
                    return false;
                }

                HashMap<CourseEnum, Double> grades = new HashMap<>();
                //course
                for (int i = 2; i < 6; i++) {
                    String[] courseTemp = strings[i].split(":");
                    if (courseTemp.length == 2 && courseTemp[1].matches(GRADE_VAILD)) {
                        CourseEnum temp = CourseEnum.resolve(courseTemp[0]);
                        if (temp != CourseEnum.UNKNOWN) {
                            grades.put(temp, Double.valueOf(courseTemp[1]));
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                if (grades.size() < CourseEnum.getCourseEnumNumber()){
                    return false;
                }
                student.setGrades(grades);
                studentHashSet.add(student);
                System.out.printf(GlobalConstants.ADD_STU_SUCCESS, student.getName());
                return true;

            }
        }
        return false;

    }


    public static void println(String string) {
        System.out.println(string);
    }

    public static void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }
}
