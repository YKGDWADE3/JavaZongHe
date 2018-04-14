package com.tw;


import java.util.*;

public class Library {
    String mString = "杨开广, 12345, 数学: 98, 英语: 88.12, 语文: 87.2, 编程: 89";
    String mString1 = "杨广, 123456, 数学: 98, 英语: 88.12, 语文: 87.2, 编程: 100";

    public static final String NAME_VAILD= "[\u4e00-\u9fa5]{2,4}";
    public static final String ID_VAILD= "^[1-9]\\d{1,9}$";
    public static final String GRADE_VAILD= "^[+]?([0-9]+(.[0-9]{1,2})?)$";

    public static void main(String[] args ) {
        Scanner input = new Scanner(System.in);
        Klass klass = new Klass();

        while (true) {
            println(GlobalConstants.MAIN_PAGE);
            String cmdLine = input.nextLine();

            if (cmdLine.equals("1")) {
                println(GlobalConstants.CHOOSE_1);
                while (true) {
                    String addStudentString = input.nextLine();
                    if (!klass.addStudentSuccess(addStudentString)) {
                        println(GlobalConstants.ADD_STU_FAIL);
                    }else{
                        System.out.printf(GlobalConstants.ADD_STU_SUCCESS, klass.getAddStudent().getName());
                        break;
                    }
                }
            } else if (cmdLine.equals("2")) {
                println(GlobalConstants.CHOOSE_2);
                while (true) {
                    String queryString = input.nextLine();
                    if (!klass.querySuccess(queryString)) {
                        println(GlobalConstants.QUERY_FAIL);
                    }else {
                        println(GlobalConstants.QUERY_SUCCESS_TITLE);
                        klass.printQueryStudents();
                        println(GlobalConstants.QUERY_SUCCESS_FOOTER);

                        break;
                    }
                }
            } else if (cmdLine.equals("3")) {
                System.exit(0);
            } else {

            }
        }
    }


    public static void println(String string) {
        System.out.println(string);
    }

    public static void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }
}
