/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.packtprimeuidemo.service;

import com.mycompany.packtprimeuidemo.dao.PersonDao;
import com.mycompany.packtprimeuidemo.model.Person;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author rmabini1
 */
@Service
public class PersonService implements java.io.Serializable{
    
    @Resource
    private PersonDao personDao;
    
    public Person findById(String id){
      return  personDao.findOne(id);
    }
        
    public void save(Person person){
       personDao.save(person);
    }
    
    public List<Person> findByFirstname(String firstname){
      return personDao.findByFirstname(firstname);
    }
    
    public List<Person> findBySurname(String surname){
      return personDao.findBySurname(surname);
    }
    
    public List<Person> findByFirstnameSurname(String firstname, String surname){
      return personDao.findByFirstnameSurname(firstname, surname);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }
    
    
    
}
