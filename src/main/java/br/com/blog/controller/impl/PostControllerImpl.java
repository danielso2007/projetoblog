package br.com.blog.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.dto.PostDTO;
import br.com.blog.entities.Post;
import br.com.blog.mapper.PostMapper;
import br.com.blog.repositories.PostRepository;
import br.com.blog.services.PostService;

public class PostControllerImpl extends BaseController<Post, PostDTO, Long, PostRepository, PostService> {

	@Autowired
	PostMapper mapper;

	@Autowired
	protected PostControllerImpl(PostService service) {
		super(service);
	}

	@Override
	public PostDTO toDto(Post entity) {
		return null;
	}

	@Override
	public List<PostDTO> toDto(List<Post> list) {
		return null;
	}

	@Override
	public Post toEntity(PostDTO dto) {
		return null;
	}

}