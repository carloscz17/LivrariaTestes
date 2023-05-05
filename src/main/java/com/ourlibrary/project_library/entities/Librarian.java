package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.EnumGender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_librarian")
public class Librarian extends Users {

    public Librarian(String cpf, String name_user, EnumGender enumGender,
                   Address address, Contact contact, Login login
    ){
        this.setCpf(cpf);
        this.setName_user(name_user);
        this.setEnumGender(enumGender);
        this.setAddress(address);
        this.getContactList().add(contact);
        this.setLogin(login);
    }
}
