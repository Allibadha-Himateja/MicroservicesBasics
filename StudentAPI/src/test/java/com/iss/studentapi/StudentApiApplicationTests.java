package com.iss.studentapi;

import com.iss.studentapi.Services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApiApplicationTests {


    private StudentService StudentService;
    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @Test
    void getAllMarks() {
        studentService.getMarksbyIdFromMarksAPI();
    }

}
