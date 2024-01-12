package cloud.projetS5.service;

import cloud.projetS5.model.Inbox;
import cloud.projetS5.model.Message;
import cloud.projetS5.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    private InboxService inboxService;

    public MessageService(MessageRepository messageRepository, InboxService inboxService) {
        this.messageRepository = messageRepository;
        this.inboxService = inboxService;
    }

//  Read message
    public List<Message> getAllByMpiresaka(String idUser1, String idUser2){
        return messageRepository.getMessageUsers(idUser1, idUser2);
    }

//    Insert message
    public Message insert(Message message){
        Inbox inbox = inboxService.saveLastMessage(message);
        return messageRepository.insert(message);
    }
}
