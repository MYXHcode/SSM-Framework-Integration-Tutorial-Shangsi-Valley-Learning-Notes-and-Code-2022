package com.myxh.spring.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class Student implements Person
{
    private Integer studentId;
    private String studentName;
    private Integer age;
    private String gender;
    private Double score;
    private String[] hobby;
    private Clazz clazz;
    private Map<String, Teacher> teacherMap;

    public Student()
    {

    }

    public Student(Integer studentId, String studentName, String gender, Integer age)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
    }

    public Student(Integer studentId, String studentName, String gender, Double score)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.score = score;
    }

    public Student(Integer studentId, String studentName, Integer age, String gender, Double score, String[] hobby, Clazz clazz, Map<String, Teacher> teacherMap)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.hobby = hobby;
        this.clazz = clazz;
        this.teacherMap = teacherMap;
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Double getScore()
    {
        return score;
    }

    public void setScore(Double score)
    {
        this.score = score;
    }

    public String[] getHobby()
    {
        return hobby;
    }

    public void setHobby(String[] hobby)
    {
        this.hobby = hobby;
    }

    public Clazz getClazz()
    {
        return clazz;
    }

    public void setClazz(Clazz clazz)
    {
        this.clazz = clazz;
    }

    public Map<String, Teacher> getTeacherMap()
    {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap)
    {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", hobby=" + Arrays.toString(hobby) +
                ", clazz=" + clazz +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
