package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_teacher")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher extends Users{
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    public Teacher(Course course, String cpf, String name, EnumGender enumGender,
                   Address address, Contact contact, Login login
    ){

        this.course = course;
        this.setCpf(cpf);
        this.setName_user(name);
        this.setEnumGender(enumGender);
        this.setAddress(address);
        this.getContactList().add(contact);
        this.setLogin(login);
    }

}
