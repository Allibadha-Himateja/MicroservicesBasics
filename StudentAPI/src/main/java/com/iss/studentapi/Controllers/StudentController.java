package com.iss.studentapi.Controllers;

import com.iss.studentapi.Models.Student;
import com.iss.studentapi.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/list")
    public List<Student> list() {
        return studentService.getStudents();
    }

    @PostMapping("/save")
    public Student saveStudent(Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{roll_no}")
    public Student findStudentByRollNo(@PathVariable int roll_no) {
        return studentService.findStudentByRollNo(roll_no);
    }

    @DeleteMapping("/{roll_no}")
    public void deleteStudentByRollNo(@PathVariable int roll_no) {
        studentService.deleteStudentByRollNo(roll_no);
    }


}
