package com.tilak.RojgarNepal.Controller;

import com.tilak.RojgarNepal.Model.Post;
import com.tilak.RojgarNepal.Service.JobService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
public class JobController
{
    @Autowired
    private JobService jobService;
    @Hidden
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    public ResponseEntity<List<Post>> getAllPosts()
    {
       List<Post> posts= jobService.getAllPosts();
       return new ResponseEntity<>(posts, HttpStatus.OK);

    }

    @PostMapping("/post")
    public ResponseEntity<Post> addJob(@RequestBody Post post)
    {
        Post data= jobService.addJob(post);
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }
}
