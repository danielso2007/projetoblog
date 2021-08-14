package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Post;
import br.com.blog.repositories.PostRepository;
import br.com.blog.services.IPostService;

public class PostService extends BaseService<Post, Long, PostRepository> implements IPostService {

	@Autowired
	public PostService(PostRepository repository) {
		super(repository);
	}

}
