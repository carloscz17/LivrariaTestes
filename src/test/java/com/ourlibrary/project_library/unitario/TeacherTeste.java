package com.ourlibrary.project_library.unitario;

import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.enuns.EnumGender;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.repositories.TeacherRepository;
import com.ourlibrary.project_library.services.StudentService;
import com.ourlibrary.project_library.services.TeacherService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class TeacherTeste {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherRepository teacherRepository;
    public Teacher teacher;

    @Test
    public void teacherCreate (){
        this.teacher = new Teacher( new Course(null, Area.EXACT_SCIENCES, "Ciência da computação")
                , "88887425140", "carlos", EnumGender.MASCULINE
                , new Address("Rua Marcio", "43", "São João", "PB", "Centro")
                , new Contact(null, "carloscga@gmail.com", "988252421", teacher),
                new Login(null, "723874", "dskajdshnchd"));

        teacherRepository.save(teacher);
        List<Teacher> teachers = teacherRepository.findAll();
        assertEquals(1, teachers.size());
        assertTrue(teachers.contains(teacher));

    }
}
