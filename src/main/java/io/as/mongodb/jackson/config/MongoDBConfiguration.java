package io.as.mongodb.jackson.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import fr.javatic.mongo.jacksonCodec.JacksonCodecProvider;
import fr.javatic.mongo.jacksonCodec.ObjectMapperFactory;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("ALL")
public class MongoDBConfiguration
{
    private CodecRegistry codecRegistry()
    {
        return CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(new JacksonCodecProvider(ObjectMapperFactory.createObjectMapper())));
    }

    @Bean
    public MongoClientOptions mongoClientOptions()
    {
        return MongoClientOptions.builder().codecRegistry(codecRegistry()).build();
    }
}
