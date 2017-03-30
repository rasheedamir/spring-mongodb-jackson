package io.as.mongodb.jackson.repository;

import io.as.mongodb.jackson.domain.ToDo;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

import java.util.function.Supplier;

public class ToDoSupplier implements Supplier<ToDo>
{
    public static ToDoSupplier INSTANCE = new ToDoSupplier();

    @Override
    public ToDo get()
    {
        EnhancedRandom random = EnhancedRandomBuilder
        .aNewEnhancedRandomBuilder()
        .stringLengthRange(20, 30)
        .collectionSizeRange(3, 5)
        .build();

        return random.nextObject(ToDo.class);
    }
}
