package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.PostDTO;
import br.com.blog.entities.Post;
import br.com.blog.repositories.PostRepository;
import br.com.blog.services.PostService;

public interface PostController extends IBaseController<Post, PostDTO, Long, PostRepository, PostService> {

}
