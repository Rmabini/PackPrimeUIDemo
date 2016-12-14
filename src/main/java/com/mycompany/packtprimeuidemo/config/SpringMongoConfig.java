/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.packtprimeuidemo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author rmabini1
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
    
    private String mongoHqUrl = "mongodb://localhost:27017/test";
    private String databaseName = "test";

    @Override
    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate;
        mongoTemplate = createMongoTemplate();
        return mongoTemplate;
    }

    private MongoTemplate createMongoTemplate() throws Exception {
        UserCredentials userCredentials = getUserCredentials();
        if (userCredentials == null) {
            return new MongoTemplate(mongo(), getDatabaseName());
        } else {
            return new MongoTemplate(mongo(), getDatabaseName(), userCredentials);
        }
    }

    @Override
    public @Bean
    Mongo mongo() throws Exception {
        return new Mongo(getMongoURI());
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public UserCredentials getUserCredentials() {
        try {
            if (getMongoURI().getUsername() == null) {
                return null;
            } else {
                UserCredentials userCredentials = new UserCredentials(getMongoURI().getUsername(),
                        String.valueOf(getMongoURI().getPassword()));
                return userCredentials;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private MongoURI getMongoURI() throws Exception {
        MongoURI mongoURI = new MongoURI(mongoHqUrl);
        return mongoURI;

    }
}
