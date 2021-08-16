package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Imagem;
import br.com.blog.repositories.ImagemRepository;

public interface ImagemService extends IBaseService<Imagem, Long, ImagemRepository> {
}
