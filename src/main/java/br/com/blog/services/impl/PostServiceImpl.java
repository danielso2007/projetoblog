package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Post;
import br.com.blog.repositories.PostRepository;
import br.com.blog.services.PostService;

public class PostServiceImpl extends BaseService<Post, Long, PostRepository> implements PostService {

	@Autowired
	public PostServiceImpl(PostRepository repository) {
		super(repository);
	}

}
