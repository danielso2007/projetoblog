package br.com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

}
