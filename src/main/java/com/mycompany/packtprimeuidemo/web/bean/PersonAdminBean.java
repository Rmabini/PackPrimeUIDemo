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

    public Person findById(String id) {
        return personService.findById(id);
    }

    public void save(Person person) {
        personService.save(person);
    }

    public List<Person> findAll() {
        return personService.findAll();
    }  
}
