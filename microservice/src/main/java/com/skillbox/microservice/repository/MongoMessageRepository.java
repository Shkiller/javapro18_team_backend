package com.skillbox.microservice.repository;

import com.skillbox.microservice.entity.MongoMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoMessageRepository extends MongoRepository<MongoMessage,Integer> {

}
