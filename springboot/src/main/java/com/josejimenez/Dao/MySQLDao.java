package com.josejimenez.Dao;

import com.josejimenez.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository("mySQL")
public class MySQLDao implements StudentDao
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student>
    {


        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException
        {
            Student student = new Student();
            student.setId(resultSet.getInt("ID"));
            student.setStudentid(resultSet.getInt("StudentID"));
            student.setLastname(resultSet.getString("Lastname"));
            student.setFirstname(resultSet.getString("Firstname"));
            student.setGrade(resultSet.getString("Grade"));
            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        // SELECT column_name(s) FROM table_name
        final String sql = "SELECT ID, StudentID,Lastname, Firstname, Grade FROM studentlistbyteacher";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Collection<Student> getStudentById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT ID, StudentID, Lastname, Firstname, Grade FROM studentlistbyteacher where ID = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        List<Student> students=new ArrayList<Student>();
        students.add(student);
        return students;
    }

    @Override
    public void removeStudentById(int id) {
        // DELETE FROM table_name
        // WHERE some_column = some_value
        final String sql = "DELETE FROM studentlistbyteacher WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateStudent(Student student) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        final String sql = "UPDATE studentlistbyteacher SET StudentID = ?, Lastname=?,Firstname=?,Grade = ? WHERE id = ?";
        final int id = student.getId();
        final int studentid = student.getStudentid();
        final String lastname = student.getLastname();
        final String firstname = student.getFirstname();
        final String grade = student.getGrade();
        jdbcTemplate.update(sql, new Object[]{studentid,lastname,firstname,grade, id});
    }

    @Override
    public void insertStudent(Student student) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO studentlistbyteacher (StudentID,Lastname,Firstname,Grade) VALUES (?, ?,?,?)";
        final int studentid = student.getStudentid();
        final String lastname = student.getLastname();
        final String firstname = student.getFirstname();
        final String grade = student.getGrade();
        jdbcTemplate.update(sql, new Object[]{studentid,lastname,firstname, grade});

    }
}
