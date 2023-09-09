package com.myxh.spring.pojo;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class Teacher
{
    private Integer teacherId;
    private String teacherName;

    public Teacher()
    {

    }

    public Teacher(Integer teacherId, String teacherName)
    {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Integer getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
