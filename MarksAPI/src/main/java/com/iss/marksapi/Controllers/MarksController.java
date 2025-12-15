package com.iss.marksapi.Controllers;

import com.iss.marksapi.Models.Marks;
import com.iss.marksapi.Services.MarksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    private MarksService marksService;

    // Use Constructor Injection (preferred over @Autowired on fields)
    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Marks>> getAllMarks() {
        List<Marks> marks = marksService.getAllMarks();
        ResponseEntity<List<Marks>> marksList=new ResponseEntity<>(marks, HttpStatus.OK);
        return marksList;
    }


    @GetMapping("/{roll_no}")
    public Marks findMarksByRollNo(@PathVariable int roll_no) {
        return marksService.findMarksByRollNo(roll_no);
    }

    @PostMapping
    public Marks saveMarks(@RequestBody Marks marks) {
        return marksService.saveMarks(marks);
    }

    @PutMapping("/{roll_no}")
    public Marks updateMarks(@PathVariable int roll_no, @RequestBody Marks marksDetails) {
        return marksService.updateMarks(roll_no, marksDetails);
    }

    @DeleteMapping("/{roll_no}")
    public void deleteMarksByRollNo(@PathVariable int roll_no) {
        marksService.deleteMarksByRollNo(roll_no);
    }

}
