package com.tilak.RojgarNepal.Repos;

import com.tilak.RojgarNepal.Model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SearchRepo {

    List<Post> search(String query);
}
