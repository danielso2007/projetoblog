package br.com.blog.commons.controller.impl;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.commons.services.IBaseService;
import br.com.blog.dto.BaseEntityDTO;
import br.com.blog.entities.BaseEntity;

public abstract class BaseController<E extends BaseEntity, D extends BaseEntityDTO, K extends Serializable, R extends IBaseRepository<E, K>, C extends IBaseService<E, K, R>>
		implements IBaseController<E, D, K, R, C> {

	private final C service;

	protected BaseController(C service) {
		this.service = service;
	}

	@Override
	public final C getService() {
		return service;
	}

	@Override
	public ResponseEntity<List<D>> findAll() {
		return ResponseEntity.ok(getService().findAll().stream().map(this::toDto).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<D> create(@Valid E object) {
		return getService().save(object).map(this::toDto).map(ResponseEntity.status(HttpStatus.CREATED)::body)
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<D> update(@Valid E object, K id) {
		return getService().update(object, id).map(this::toDto).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<D> find(@PathVariable K id) {
		return getService().findById(id).map(this::toDto).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Object> delete(@PathVariable K id) {
		return getService().findById(id).map(entity -> {
			getService().delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
