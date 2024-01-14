package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Message;
import org.project.clouds5_backend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(String id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
