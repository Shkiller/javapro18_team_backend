package com.skillbox.microservice.repository;

import com.skillbox.microservice.entity.MongoMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoMessageRepository extends MongoRepository<MongoMessage, String> {

}
