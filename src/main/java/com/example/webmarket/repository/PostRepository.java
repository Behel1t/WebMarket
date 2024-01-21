package com.example.webmarket.repository;

import com.example.webmarket.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {
}
