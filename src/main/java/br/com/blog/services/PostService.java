package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Post;
import br.com.blog.repositories.PostRepository;

public interface IPostService extends IBaseService<Post, Long, PostRepository> {
}
