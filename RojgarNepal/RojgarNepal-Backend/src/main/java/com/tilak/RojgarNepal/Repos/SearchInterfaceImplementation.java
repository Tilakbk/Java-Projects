package com.tilak.RojgarNepal.Repos;

import com.tilak.RojgarNepal.Model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchInterfaceImplementation implements SearchRepo{
    @Override
    public List<Post> search(String query)
    {

        return null;
    }
}
