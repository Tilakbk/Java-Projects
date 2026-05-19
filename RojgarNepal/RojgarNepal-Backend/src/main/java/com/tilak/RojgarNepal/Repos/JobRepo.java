package com.tilak.RojgarNepal.Repos;

import com.tilak.RojgarNepal.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends MongoRepository<Post,String> {
}
