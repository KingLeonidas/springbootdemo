package com.josejimenez.Entity;

public class Student
{
    private int id;
    private int studentid;
    private String Lastname;
    private String Firstname;
    private String grade;


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student(int id, int studentid, String Lastname, String Firstname, String grade)
    {
        this.id = id;
        this.studentid = studentid;
        this.Lastname = Lastname;
        this.Firstname=Firstname;
        this.grade=grade;
    }

    public Student()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
