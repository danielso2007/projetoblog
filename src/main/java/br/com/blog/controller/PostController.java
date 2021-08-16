package br.com.blog.controller;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.PostDTO;
import br.com.blog.entities.Post;
import br.com.blog.repositories.PostRepository;
import br.com.blog.services.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Post.class)
@RequestMapping(Constants.POST)
@Tag(name = "Post", description = "Os post de um usuário.")
public interface PostController extends IBaseController<Post, PostDTO, Long, PostRepository, PostService> {

}
