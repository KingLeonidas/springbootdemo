package com.josejimenez.Controller;

import com.josejimenez.Entity.Student;
import com.josejimenez.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController
{

    @Autowired
    private StudentService studentService;

    @RequestMapping(method= RequestMethod.GET)
    public Collection<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @RequestMapping(value ="/{id}", method=RequestMethod.GET)
    public Collection<Student> getStudentById(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id)
    {
        studentService.removeStudentById(id);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student)
    {
        studentService.updateStudent(student);
    }

    @RequestMapping(method=RequestMethod.POST)
    public void insertStudent(@RequestBody Student student)
    {
        studentService.insertStudent(student);
    }

}
