package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Message;
import org.project.clouds5_backend.model.Reponse;
import org.project.clouds5_backend.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
            this.messageService = messageService;
    }

    @GetMapping("/all")
    public ResponseEntity<Reponse<List<Message>>> getAllMessages() {
        Reponse<List<Message>> reponse = new Reponse<>();
        try {
            List<Message> messages = messageService.getAllMessages();
            if (!messages.isEmpty()) {
                reponse.setData(messages);
                reponse.setRemarque("Liste des messages");
                return ResponseEntity.ok().body(reponse);
            } else {
                reponse.setErreur("Liste vide");
                return ResponseEntity.status(404).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @PostMapping
    public ResponseEntity<Reponse<Message>> createMessage(Message message) {
        Reponse<Message> reponse = new Reponse<>();
        try {
            Message newMessage = messageService.createMessage(message);
            if (newMessage != null) {
                reponse.setData(newMessage);
                reponse.setRemarque("Message cree");
                return ResponseEntity.ok().body(reponse);
            } else {
                reponse.setErreur("Message non cree");
                return ResponseEntity.status(404).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }
}
