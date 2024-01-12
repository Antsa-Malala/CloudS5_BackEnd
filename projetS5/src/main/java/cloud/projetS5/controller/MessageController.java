package cloud.projetS5.controller;

import cloud.projetS5.model.Message;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("apiMessage")
@RestController
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages/{id1}/{id2}")
    Reponse<List<Message>> getCOnversations(@PathVariable String id1, @PathVariable String id2){
        Reponse<List<Message>> valiny = new Reponse<>();
        try {
            valiny.setData(messageService.getAllByMpiresaka(id1, id2));
        } catch (Exception e){
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/message")
    public Reponse<Message> insert(@RequestBody Message message){
        Reponse<Message> valiny = new Reponse<>();
        try {
            valiny.setData(messageService.insert(message));
        } catch (Exception e){
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
