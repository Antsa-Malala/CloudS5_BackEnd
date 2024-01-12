package cloud.projetS5.controller;

import cloud.projetS5.model.Inbox;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.InboxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("apiInbox")
@RestController
public class InboxController {
    private InboxService inboxService;

    public InboxController(InboxService inboxService) {
        this.inboxService = inboxService;
    }

    @GetMapping("/inbox/{id}")
    Reponse<List<Inbox>> getInbox(@PathVariable String id){
        Reponse<List<Inbox>> valiny = new Reponse<>();
        try {
            valiny.setData(inboxService.getMyBox(id));
        } catch (Exception e){
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
