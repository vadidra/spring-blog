package com.vadidra.blog;

import com.vadidra.blog.model.Author;
import com.vadidra.blog.model.Comment;
import com.vadidra.blog.model.Post;
import com.vadidra.blog.repository.AuthorRepository;
import com.vadidra.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@Component
@ActiveProfiles("test")
public class TestDataLoader implements CommandLineRunner {

    private final AuthorRepository authors;
    private final PostRepository posts;

    public TestDataLoader(AuthorRepository authors, PostRepository posts) {
        this.authors = authors;
        this.posts = posts;
    }

    @Override
    public void run(String... args) throws Exception {
        AggregateReference<Author,Integer> author = AggregateReference.to(authors.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());
        Post post = new Post("Hello, World!","Welcome to my Spring Blog", author);
        post.addComment(new Comment( "Dan", "This is a comment"));
        post.addComment(new Comment( "John", "This is another comment"));
        posts.save(post);
    }
}
