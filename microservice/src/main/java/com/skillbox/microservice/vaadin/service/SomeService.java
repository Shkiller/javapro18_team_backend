package com.skillbox.microservice.vaadin.service;

import com.skillbox.microservice.entity.Message;
import com.skillbox.microservice.entity.MongoMessage;
import com.skillbox.microservice.repository.MessageRepository;
import com.skillbox.microservice.repository.MongoMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SomeService {
    //    private final MessageRepository messageRepository;
    private final MongoMessageRepository messageRepository;

    public void deleteMessage(MongoMessage message) {
        Optional<MongoMessage> m = messageRepository.findById(message.getId());
        if (m.isPresent()) {
            messageRepository.deleteById(message.getId());
        }
    }

    public List<MongoMessage> getAllMessages() {
        return messageRepository.findAll();
    }
}
