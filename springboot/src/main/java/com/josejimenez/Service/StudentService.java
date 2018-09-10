package com.josejimenez.Service;

import com.josejimenez.Dao.StudentDao;
import com.josejimenez.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService
{
    @Autowired
    @Qualifier("mySQL")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents()
    {
        return this.studentDao.getAllStudents();
    }

    public Collection<Student> getStudentById(int id)
    {
        return this.studentDao.getStudentById(id);
    }

    public void removeStudentById(int id)
    {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student)
    {
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student)
    {
        this.studentDao.insertStudent(student);
    }


}
