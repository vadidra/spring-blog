package com.vadidra.blog.repository;

import com.vadidra.blog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    Author findByUsername(String username);
}
