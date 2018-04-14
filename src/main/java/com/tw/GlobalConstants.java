package com.tw;

public class GlobalConstants {
    public static final String MAIN_PAGE =
            "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出请输入你的选择（1～3）：";

    public static final String CHOOSE_1 = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";

    public static final String CHOOSE_2 = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交: ";

    public static final String ADD_STU_FAIL = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";

    public static final String ADD_STU_SUCCESS = "学生%s的成绩被添加\n\n";

    public static final String QUERY_FAIL = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";

    public static final String QUERY_SUCCESS_TITLE = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分\n" +
            "========================";

    public static final String QUERY_SUCCESS_FOOTER = "========================";
    public static final String QUERY_SUCCESS_TOTAL = "全班总分平均数：";
    public static final String QUERY_SUCCESS_MED = "全班总分中位数：";

}
