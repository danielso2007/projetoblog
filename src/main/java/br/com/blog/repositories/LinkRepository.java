package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.entities.Link;

@Repository
public interface LinkRepository extends IBaseRepository<Link, Long> {

}
