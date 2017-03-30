package io.as.mongodb.jackson.repository;

import io.as.mongodb.jackson.Application;
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
}