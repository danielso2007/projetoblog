package br.com.blog.commons.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.entities.BaseEntity;

public interface IBaseService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>> {

	UserDetails getUser();

	R getRepository();

	void delete(final K id);

	Optional<E> findById(final K id);

	Optional<E> save(E object);

	Optional<E> update(E object, final K id);

	List<E> findAll();

	Class<E> getEntityClass();

}
