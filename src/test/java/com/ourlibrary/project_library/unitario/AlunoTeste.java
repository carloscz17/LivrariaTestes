package com.ourlibrary.project_library.unitario;


import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.enuns.EnumGender;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.services.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class AlunoTeste {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    public Student student;

    @Test
    public void alunoCreate (){
        this.student = new Student("7", new Course(null, Area.EXACT_SCIENCES, "Computer Science")
                , "18954707068", "ntest", EnumGender.MASCULINE, new Address("Rua dos bobos", "3", "cidade abadon" +
                "ada", "PB", "bairro das freiras"), new Contact(null, "iran7826@uorak.com", "832367273", student),
                new Login(null, "625655", "csdljvbljvlcjn"));

        studentRepository.save(student);
        List<Student> students = studentRepository.findAll();
        assertEquals(1, students.size());
        assertTrue(students.contains(student));

    }

}
