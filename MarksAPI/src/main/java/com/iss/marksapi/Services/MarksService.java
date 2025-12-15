package com.iss.marksapi.Services;

import com.iss.marksapi.Models.Marks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarksService {

    private List<Marks> marksDatabase;


    public MarksService() {
        marksDatabase = new ArrayList<>();
        marksDatabase.add(Marks.builder().roll_no(1).math(85).physics(78).chemistry(92).build());
        marksDatabase.add(Marks.builder().roll_no(2).math(95).physics(88).chemistry(81).build());
        marksDatabase.add(Marks.builder().roll_no(3).math(65).physics(72).chemistry(77).build());
    }


    public List<Marks> getAllMarks() {
        return marksDatabase;
    }


    public Marks saveMarks(Marks marks) {
        // In a real application, you would ensure the roll_no is unique or update
        // an existing record. Here, we simply add it.
        marksDatabase.add(marks);
        return marks;
    }

    public Marks findMarksByRollNo(int roll_no) {
        return marksDatabase.stream()
                .filter(marks -> marks.getRoll_no() == roll_no)
                .findFirst()
                .orElse(null);
    }


    public Marks updateMarks(int roll_no, Marks updatedMarks) {
        Marks existingMarks = findMarksByRollNo(roll_no);

        if (existingMarks != null) {
            // Update fields if the record is found
            existingMarks.setMath(updatedMarks.getMath());
            existingMarks.setPhysics(updatedMarks.getPhysics());
            existingMarks.setChemistry(updatedMarks.getChemistry());
            return existingMarks;
        }
        return null; // Marks record not found for update
    }


    public boolean deleteMarksByRollNo(int roll_no) {
        // removeIf returns true if any element was removed
        return marksDatabase.removeIf(marks -> marks.getRoll_no() == roll_no);
    }
}