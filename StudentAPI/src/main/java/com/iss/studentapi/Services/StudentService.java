package com.iss.studentapi.Services;

import com.iss.studentapi.Models.Marks;
import com.iss.studentapi.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students;

    @Autowired
    WebClient.Builder webClient;

    @Autowired
    private RestTemplate restTemplate;

    public StudentService() {
        students = new ArrayList<>();
        students.add(Student.builder().roll_no(1).name("ravi").fees(20000).build());
        students.add(Student.builder().roll_no(2).name("ram").fees(15000).build());
        students.add(Student.builder().roll_no(3).name("venu").fees(22000).build());
    }
    public List<Student> getStudents() {
        return students;
    }
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }
    public Student findStudentByRollNo(int roll_no) {
        return students.stream().filter(student -> student.getRoll_no() == roll_no).findFirst().orElse(null);
    }
    public Student deleteStudentByRollNo(int roll_no) {
        students.removeIf(student -> student.getRoll_no() == roll_no);
        return findStudentByRollNo(roll_no);
    }

    public void getMarksFromMarksAPI()
    {
        ResponseEntity<List<Marks>> entity = restTemplate.exchange("http://MARKS-API/marks/list", HttpMethod.GET,null,new ParameterizedTypeReference<List<Marks>>() {});
        entity.getBody().stream().forEach(System.out::println);
    }

    public void getMarksbyIdFromMarksAPI()
    {
        //ResponseEntity<Marks> entity = restTemplate.exchange("http://localhost:8081/marks/1",HttpMethod.GET,null,Marks.class);
        //System.out.println(entity.getBody());
        Mono<ResponseEntity<List<Marks>>> marks=webClient.build().get().uri("/marks/list")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Marks>>() {});

        marks.subscribe(p->p.getBody().stream().forEach(System.out::println));

    }
}
