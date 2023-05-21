package com.vadidra.blog.model.dto;

import com.vadidra.blog.model.Author;
import com.vadidra.blog.model.Post;

public record PostDetails(Post post, Author author) { }
