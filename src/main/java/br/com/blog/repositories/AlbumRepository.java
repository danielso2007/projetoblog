package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.entities.Album;

@Repository
public interface AlbumRepository extends IBaseRepository<Album, Long> {

}
