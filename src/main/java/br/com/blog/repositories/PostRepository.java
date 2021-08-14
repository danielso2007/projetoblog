package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.entities.Post;

@Repository
public interface PostRepository extends IBaseRepository<Post, Long> {

}
