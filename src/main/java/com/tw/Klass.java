package com.tw;

import java.util.*;

public class Klass {
    private HashMap<Long, Student> mStudents = new HashMap<>();

    private Double mTotalGrades = new Double(0);

    private Double mAverageGrades;

    private HashMap<Long, Student> mQueryStudents = new HashMap<>();

    private Student mAddStudent;

    public boolean addStudentSuccess(String studentString) {
        if (studentString != null && !studentString.isEmpty()){
            Student student = new Student();
            String[] strings = studentString.replaceAll(" ", "").split(",");
            if (strings.length == 6) {
                //name
                if (strings[0].matches(Library.NAME_VAILD)) {
                    student.setName(strings[0]);
                }else{
                    return false;
                }
                //id
                if (strings[1].matches(Library.ID_VAILD)) {
                    student.setId(Long.parseLong(strings[1]));
                } else {
                    return false;
                }

                TreeMap<CourseEnum, Double> grades = new TreeMap<>(Comparator.naturalOrder());
                double studentTotalGrade = 0;
                //course
                for (int i = 2; i < 6; i++) {
                    String[] courseTemp = strings[i].split(":");
                    if (courseTemp.length == 2 && courseTemp[1].matches(Library.GRADE_VAILD)) {
                        CourseEnum temp = CourseEnum.resolve(courseTemp[0]);
                        if (temp != CourseEnum.UNKNOWN) {
                            studentTotalGrade += Double.valueOf(courseTemp[1]);
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
                student.setTotalGrade(studentTotalGrade);
                mAddStudent = student;
                if (!mStudents.containsKey(mAddStudent.getId())){
                    mTotalGrades += mAddStudent.getTotalGrade();
                    mStudents.put(mAddStudent.getId(), mAddStudent);
                }
                return true;

            }
        }
        return false;

    }

    public boolean querySuccess(String queryString){
        if (queryString != null && !queryString.isEmpty()) {
            String[] strings = queryString.replaceAll(" ", "").split(",");
            int length = strings.length;
            mQueryStudents.clear();

            for (int i = 0; i < length; i++) {
                Long id = Long.valueOf(strings[i]);
                if (strings[i].matches(Library.ID_VAILD)) {
                    if (mStudents.containsKey(id)) {
                        mQueryStudents.put(id, mStudents.get(id));
                    } else {
                        continue;
                    }

                } else {
                    return false;
                }
            }
            if (mQueryStudents.size() > 0) {
                return true;
            }
            return false;


        }
        return false;
    }
    
    public void printQueryStudents(){
        Iterator iterator = mQueryStudents.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Student> entry = (Map.Entry<Long, Student>) iterator.next();
            Student temp = entry.getValue();
            System.out.print(temp.getName());
            Iterator it = temp.getGrades().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<CourseEnum, Double> entry1 = (Map.Entry<CourseEnum, Double>) it.next();
                System.out.print("|" + entry1.getValue());
            }
            System.out.println("|" + temp.getTotalGrade() + "|" + String.format("%.2f", temp.getTotalGrade() / CourseEnum.getCourseEnumNumber()));
            System.out.println(GlobalConstants.QUERY_SUCCESS_FOOTER);
            System.out.println(GlobalConstants.QUERY_SUCCESS_TOTAL + getTotalGrades());
            System.out.println(GlobalConstants.QUERY_SUCCESS_MED + String.format("%.2f", getClassMedGrades()));

        }
    }

    public double getClassMedGrades() {
        ArrayList<Double> studentGrades = new ArrayList<>();
        Iterator iterator = mStudents.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Student> entry = (Map.Entry<Long, Student>) iterator.next();
            studentGrades.add(entry.getValue().getTotalGrade());
        }
        Collections.sort(studentGrades);
        int size = studentGrades.size();
        if (size % 2 == 0) {
            return (studentGrades.get(size / 2) + studentGrades.get(size / 2 - 1)) / 2;
        } else {
            return studentGrades.get(size / 2);
        }
    }
    public HashMap<Long, Student> getStudents() {
        return mStudents;
    }

    public void setStudents(HashMap<Long, Student> students) {
        mStudents = students;
    }

    public Double getTotalGrades() {
        return mTotalGrades;
    }

    public void setTotalGrades(Double totalGrades) {
        mTotalGrades = totalGrades;
    }

    public Double getAverageGrades() {
        return mAverageGrades;
    }

    public void setAverageGrades(Double averageGrades) {
        mAverageGrades = averageGrades;
    }

    public HashMap<Long, Student> getQueryStudents() {
        return mQueryStudents;
    }

    public void setQueryStudents(HashMap<Long, Student> queryStudents) {
        mQueryStudents = queryStudents;
    }

    public Student getAddStudent() {
        return mAddStudent;
    }

    public void setAddStudent(Student addStudent) {
        mAddStudent = addStudent;
    }
}
