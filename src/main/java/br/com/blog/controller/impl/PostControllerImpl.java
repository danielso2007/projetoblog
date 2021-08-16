package br.com.blog.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.controller.PostController;
import br.com.blog.dto.PostDTO;
import br.com.blog.entities.Post;
import br.com.blog.mapper.PostMapper;
import br.com.blog.repositories.PostRepository;
import br.com.blog.services.PostService;

@RestController
public class PostControllerImpl extends BaseController<Post, PostDTO, Long, PostRepository, PostService> implements PostController {

	@Autowired
	PostMapper mapper;

	@Autowired
	protected PostControllerImpl(PostService service) {
		super(service);
	}

	@Override
	public PostDTO toDto(Post entity) {
		return mapper.toDTO(entity);
	}

	@Override
	public List<PostDTO> toDto(List<Post> list) {
		return list.stream().map(v -> mapper.toDTO(v)).collect(Collectors.toList());
	}

	@Override
	public Post toEntity(PostDTO dto) {
		return mapper.toEntity(dto);
	}

}
