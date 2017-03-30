package io.as.mongodb.jackson.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import fr.javatic.mongo.jacksonCodec.JacksonCodecProvider;
import fr.javatic.mongo.jacksonCodec.ObjectMapperFactory;
import io.as.mongodb.jackson.Application;
import io.as.mongodb.jackson.domain.ToDo;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ToDoRepositoryTest
{
    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    public void shouldSave()
    {
        toDoRepository.save(ToDoSupplier.INSTANCE.get());
    }

    @Test
    public void shouldSaveUsingJacksonCodec()
    {
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(new JacksonCodecProvider(ObjectMapperFactory.createObjectMapper())));

        MongoClientOptions clientOptions = MongoClientOptions.builder()
                .codecRegistry(codecRegistry)
                .build();

        MongoClient client = new MongoClient(new ServerAddress("localhost", 49893), clientOptions);

        client.getDatabase("test").createCollection("todo");

        MongoCollection<ToDo> todos = client.getDatabase("test").getCollection("todo", ToDo.class);

        todos.insertOne(ToDoSupplier.INSTANCE.get());
    }
}