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

        studentService.getMarksFromMarksAPI();// this is the restTemplate call

        studentService.getMarksbyIdFromMarksAPI(); // this is the webClient call

        // each of these calls are made from the service class but we have to make sure
        // that we dont forget about how we have configured this restTemplate and the webClient Beans

    }

}
