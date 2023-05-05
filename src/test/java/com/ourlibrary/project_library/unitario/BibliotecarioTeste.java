package com.ourlibrary.project_library.unitario;

import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.enuns.EnumGender;
import com.ourlibrary.project_library.repositories.LibrarianRepository;
import com.ourlibrary.project_library.repositories.LibraryRepository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.services.LibrarianService;
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
public class BibliotecarioTeste{
    @Autowired
    private LibrarianService librarianService;
    @Autowired
    private LibrarianRepository librarianRepository;
    public Librarian librarian;

    @Test
    public void bibliotecarioCreate (){
        this.librarian = new Librarian("88887425140","carlos", EnumGender.MASCULINE
                , new Address("Rua Vicente da Silva", "32", "São José de Piranhas", "PB", "Centro")
                , new Contact(null, "carlosbrz@gmail.com", "988252421", librarian)
                , new Login(null, "283742", "dsaokdoasokd"));

        librarianRepository.save(librarian);
        List<Librarian> librarians = librarianRepository.findAll();
        assertEquals(1, librarians.size());
        assertTrue(librarians.contains(librarian));

    }
}
