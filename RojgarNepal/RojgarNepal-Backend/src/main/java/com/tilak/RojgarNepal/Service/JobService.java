package com.tilak.RojgarNepal.Service;

import java.util.List;
import com.tilak.RojgarNepal.Model.Post;
import com.tilak.RojgarNepal.Repos.JobRepo;
import com.tilak.RojgarNepal.Repos.SearchInterfaceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private SearchInterfaceImplementation searchInterfaceImplementation;

    public List<Post> getAllPosts() {
        return jobRepo.findAll();
    }

    public Post addJob(Post post) {
       return jobRepo.save(post);

    }

    public List<Post> search(String query)
    {
        return searchInterfaceImplementation.search(query);
    }
}
