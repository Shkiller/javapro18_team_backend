package com.skillbox.microservice.vaadin.service;

import com.skillbox.microservice.entity.Message;
import com.skillbox.microservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SomeService {
    private final MessageRepository messageRepository;

    public void deleteMessage(Message message) {
        Optional<Message> m = messageRepository.findById(message.getId());
        if (m.isPresent()) {
            messageRepository.deleteById(message.getId());
        }
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
