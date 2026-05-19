package com.tilak.RojgarNepal.Repos;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tilak.RojgarNepal.Model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class SearchInterfaceImplementation implements SearchRepo{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> search(String query)
    {

        final List<Post> posts= new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("RojgarNepal");
        MongoCollection<Document> collection = database.getCollection("Jobpost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", query)
                                                .append("path", Arrays.asList("desc", "profile", "techs"))
                                )
                ),
                new Document("$sort", new Document("exp", 1L)),
                new Document("$limit", 4L)));

        result.forEach(doc-> posts.add(converter.read(Post.class,doc)));

        return posts;
    }
}
