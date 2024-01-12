package cloud.projetS5.repository;

import cloud.projetS5.model.Inbox;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InboxRepository extends MongoRepository<Inbox, String> {
    @Query(value = "{ $or: [ { 'idUtilisateur1': ?0 }, { 'idUtilisateur2': ?0 } ] }", sort = "{ 'dateMessage': -1 }")
    List<Inbox> getMyInbox(String idUser);

    @Query(value = "{ $or: [ { 'idUtilisateur1': ?0, 'idUtilisateur2': ?1 }, { 'idUtilisateur1': ?1, 'idUtilisateur2': ?0 } ] }")
    Inbox ourLastMessage(String idUser1, String idUser2);

    @Query(value = "{ $or: [ { 'idUtilisateur1': ?0, 'idUtilisateur2': ?1 }, { 'idUtilisateur1': ?1, 'idUtilisateur2': ?0 } ] }", delete = true)
    Inbox deleteInbox(String idUser1, String idUser2);
}
