package com.tilak.RojgarNepal.Config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(
                "TilakBk",
                "admin",
                "Tilak@9862".toCharArray()
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyToSslSettings(ssl -> ssl.enabled(true))
                .applyToClusterSettings(cluster -> cluster
                        .srvHost("tilak.sn36wnm.mongodb.net")  // ← only this, no .hosts()
                )
                .applicationName("Tilak")
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "RojgarNepal");
    }
}