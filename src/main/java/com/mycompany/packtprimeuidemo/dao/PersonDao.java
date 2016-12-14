


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.packtprimeuidemo.dao;

import com.mycompany.packtprimeuidemo.model.Person;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rmabini1
 */
@Repository
public interface PersonDao extends MongoRepository<Person,String>, java.io.Serializable {
    
    @Query("{firstname:?0}")
    List<Person> findByFirstname(String firstname);
    
    @Query("{surname:?0}")
    List<Person> findBySurname(String surname);
    
    @Query("{firtsname:?0 , surname:?1}")
    List<Person> findByFirstnameSurname(String firstname,String surname);
    
    
}
