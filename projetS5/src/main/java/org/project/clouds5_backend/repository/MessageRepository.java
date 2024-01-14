package org.project.clouds5_backend.repository;

import org.project.clouds5_backend.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
