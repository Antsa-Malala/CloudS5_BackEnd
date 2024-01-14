package org.project.clouds5_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "message")
public class Message {
    @Id
    @Field("_id")
    private String id;
    @Field("id_utilisateur1")
    private String idUtilisateur1;
    @Field("id_utilisateur2")
    private String idUtilisateur2;
    private String message;
    @Field("date_message")
    private LocalDateTime dateMessage;

    public String getIdUtilisateur1() {
        return idUtilisateur1;
    }

    public void setIdUtilisateur1(String idUtilisateur1) {
        this.idUtilisateur1 = idUtilisateur1;
    }

    public String getIdUtilisateur2() {
        return idUtilisateur2;
    }

    public void setIdUtilisateur2(String idUtilisateur2) {
        this.idUtilisateur2 = idUtilisateur2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(LocalDateTime dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Message() {
    }

    public Message(String idUtilisateur1, String idUtilisateur2, String message, LocalDateTime dateMessage) {
        this.setIdUtilisateur1(idUtilisateur1);
        this.setIdUtilisateur2(idUtilisateur2);
        this.setMessage(message);
        this.setDateMessage(dateMessage);
    }
}
