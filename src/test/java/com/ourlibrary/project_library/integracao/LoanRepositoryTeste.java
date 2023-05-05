package com.ourlibrary.project_library.integracao;

import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.enuns.EnumGender;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.services.BookService;
import com.ourlibrary.project_library.services.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class LoanRepositoryTeste {
    public Student student;
    public Book book;
    public Loan loan;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LoanService loanService;
    @Test
    public void testCreateLoan(){
        this.student = new Student("7", new Course(null, Area.EXACT_SCIENCES, "Ciência da computação")
                , "88887425140", "Carlos", EnumGender.MASCULINE, new Address("Rua José Vicente", "11", "Cajazeiras"
                , "PB", "Centro"), new Contact(null, "carlosczedu@gmail.com", "988252421", student), new Login(null, "69690239", "neymarjunior")
        );

        this.book = new Book();
        book.setName("IA");
        book.setIsbn("8717872-0");
        book.setArea(Area.EXACT_SCIENCES);
        book.setIsAvailable(true);
        this.loan = new Loan();
        loan.setStudent(student);
        loan.setLoanDate(LocalDate.now());
        loan.setBook(book);
        loan.setStatus("borrowed ");
        loan.setDate_devolution(loan.getLoanDate().plusDays(5));

        studentRepository.save(student);
        bookService.insert(book);
        loanService.insert(loan);

        assertNotNull(loan.getId());
        assertEquals(false, bookService.findById(book.getIsbn()).getIsAvailable());

    }

}