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
import static org.springframework.web.util.TagUtils.SCOPE_SESSION;

/**
 *
 * @author rmabini1
 */
@Scope(SCOPE_SESSION)
@Controller
public class PersonAdminBean {

    @Resource
    private PersonService personService;
    private String firstname;
    private String surname;
    private Person selectedPerson;

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
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

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Person findById(String id) {
        return personService.findById(id);
    }

    public void save(Person person) {
        personService.save(person);
    }

    public List<Person> findAll() {
        return personService.findAll();
    }

    public String displayAddPerson() {
        this.firstname = "";
        this.surname = "";
        return "addPerson.jsf?faces-redirect=true";
    }

    public String displayEditPerson(Person person) {
        this.selectedPerson = person;
        populatePerson(person);
        return "editPerson.jsf?faces-redirect=true";
    }

    public String displayDeletePerson(Person person) {
        this.selectedPerson = person;
        populatePerson(person);
        return "deletePerson.jsf?faces-redirect=true";
    }

    private void populatePerson(Person person) {
        this.firstname = person.getFirstname();
        this.surname = person.getSurname();
    }

    public String addPerson() {
        Person newPerson = new Person();
        newPerson.setFirstname(firstname);
        newPerson.setSurname(surname);
        this.save(newPerson);
        return "index.jsf?faces-redirect=true";

    }

    public String editPerson() {
        this.selectedPerson.setFirstname(firstname);
        this.selectedPerson.setSurname(surname);
        save(this.selectedPerson);
        return "index.jsf?faces-redirect=true";

    }

    public String deletePerson() {
        personService.remove(this.selectedPerson);
        return "index.jsf?faces-redirect=true";

    }
}
