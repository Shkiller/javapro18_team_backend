package com.skillbox.microservice.service;

import com.skillbox.microservice.dto.SupportRequestDto;
import com.skillbox.microservice.entity.Client;
import com.skillbox.microservice.entity.Message;
import com.skillbox.microservice.entity.MongoClient;
import com.skillbox.microservice.entity.MongoMessage;
import com.skillbox.microservice.repository.ClientRepository;
import com.skillbox.microservice.repository.MessageRepository;
import com.skillbox.microservice.repository.MongoMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
//    private final MessageRepository messageRepository;
//    private final ClientRepository clientRepository;
    private final MongoMessageRepository messageRepository;

//    public ArrayList<Message> messageOutput() {
//        Iterable<Message> messageIterable = messageRepository.findAll();
//        ArrayList<Message> messageList = new ArrayList<>();
//        for (Message message : messageIterable) {
//            messageList.add(message);
//        }
//        return messageList;
//    }

    public void saveMessage(SupportRequestDto dto) {
        MongoClient client = getClientFromMessageDto(dto);
//        Optional<Client> clientOptional = clientRepository.findByEmail(c.getEmail());
//
//        Client client = clientOptional.orElseGet(() -> clientRepository.save(c));
        MongoMessage messageOfSupport = getMessageFromMessageDto(dto, client);

        messageRepository.save(messageOfSupport);
    }

    private MongoClient getClientFromMessageDto(SupportRequestDto dto) {
//        Client client = new Client();
//        client.setFirstName(dto.getFirstName());
//        client.setLastName(dto.getLastName());
//        client.setEmail(dto.getEmail());
        MongoClient client = new MongoClient();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(dto.getEmail());
        return client;
    }

    private MongoMessage getMessageFromMessageDto(SupportRequestDto dto, MongoClient client) {
//        Message messageOfSupport = new Message();
//        messageOfSupport.setDateOfApplication(LocalDateTime.now());
//        messageOfSupport.setClient(client);
//        messageOfSupport.setMessage(dto.getMessage());
        MongoMessage messageOfSupport = new MongoMessage();
        messageOfSupport.setDateOfApplication(LocalDateTime.now());
        messageOfSupport.setClient(client);
        messageOfSupport.setMessage(dto.getMessage());

        return messageOfSupport;
    }

}
