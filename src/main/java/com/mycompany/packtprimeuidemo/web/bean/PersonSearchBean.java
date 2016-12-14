/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.packtprimeuidemo.web.bean;

import com.mycompany.packtprimeuidemo.model.Person;
import com.mycompany.packtprimeuidemo.service.PersonService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import static org.springframework.web.util.TagUtils.SCOPE_REQUEST;

/**
 *
 * @author rmabini1
 */
@Scope(SCOPE_REQUEST)
@Controller
public class PersonSearchBean implements java.io.Serializable {

    @Resource
    private PersonService personService;
    private String firstname;
    private String surname;
    private List<Person> personList;

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void search() {
        if ((firstname.trim().equals("")) && (!surname.trim().equals(""))) {
            personList = personService.findBySurname(surname);

        } else if ((!firstname.trim().equals("")) && (surname.trim().equals(""))) {
            personList = personService.findByFirstname(firstname);

        } else {
            personList = personService.findByFirstnameSurname(firstname, surname);
        }

    }

    public void test() {
        System.out.println("test");
    }
}
