package com.myxh.spring.pojo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class Clazz
{
    private Integer clazzId;
    private String clazzName;
    private List<Student> students;

    public Clazz()
    {

    }

    public Clazz(Integer clazzId, String clazzName, List<Student> students)
    {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
        this.students = students;
    }

    public Integer getClazzId()
    {
        return clazzId;
    }

    public void setClazzId(Integer clazzId)
    {
        this.clazzId = clazzId;
    }

    public String getClazzName()
    {
        return clazzName;
    }

    public void setClazzName(String clazzName)
    {
        this.clazzName = clazzName;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public String toString()
    {
        return "Clazz{" +
                "clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                ", students=" + students +
                '}';
    }
}
