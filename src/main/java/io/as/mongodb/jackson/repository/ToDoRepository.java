package io.as.mongodb.jackson.repository;

import io.as.mongodb.jackson.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String>
{

}
