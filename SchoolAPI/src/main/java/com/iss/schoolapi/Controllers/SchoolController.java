package com.iss.schoolapi.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Value("${school.name}")
    private String SchoolName;


    @GetMapping
    public String getSchoolName() {
        return SchoolName;
    }

}
