package br.com.blog.commons.services.impl;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.commons.services.IBaseService;
import br.com.blog.commons.utils.GenericsUtils;
import br.com.blog.entities.BaseEntity;

@Transactional(readOnly = true)
public abstract class BaseService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>>
		implements IBaseService<E, K, R> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public static final String ANONYMOUS = "Anonymous";
	public static final String ENTIDADE_NAO_PODE_SER_NULA = "A entidade não pode ser nula.";
	public static final String O_CAMPO_NAO_EXISTE_FORMATO = "O campo {} não existe.";

	private final R repository;
	private final Class<E> entityClass;

	protected BaseService(R repository) {
		this.repository = repository;
		this.entityClass = GenericsUtils.getGenericsInfo(this).getType(0);
	}

	@Override
	public UserDetails getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || ANONYMOUS.equals(auth.getPrincipal())) {
			return new User(ANONYMOUS, "", false, false, false, false, new ArrayList<>());
		} else {
			return (UserDetails) auth.getPrincipal();
		}
	}

	@Override
	public R getRepository() {
		return repository;
	}

	@Transactional
	@Override
	public void delete(K id) {
		logger.debug("Deletando registro {}: {}", getEntityClass(), id);
		getRepository().deleteById(id);
	}

	@Override
	public Optional<E> findById(K id) {
		if (id == null) {
			return Optional.empty();
		}
		logger.debug("Obtendo {} registration -> {}", getEntityClass(), id);
		return getRepository().findById(id);
	}

	@Transactional
	@Override
	public Optional<E> save(E entity) {
		logger.debug("Salvando registro {}", getEntityClass());
		return Optional.ofNullable(getRepository().save(entity));
	}

	@Transactional
	@Override
	public Optional<E> update(E entity, K id) {
		if (entity == null) {
			throw new IllegalArgumentException(ENTIDADE_NAO_PODE_SER_NULA);
		}
		logger.debug("aAtualizando registro {}: {}", getEntityClass(), id);
		Optional<E> opt = getRepository().findById(id);
		if (opt.isEmpty()) {
			return Optional.empty();
		}
		E entityOriginal = opt.get();
		BeanUtils.copyProperties(entity, entityOriginal, getNullPropertyNames(entity));
		return Optional.of(getRepository().save(entityOriginal));
	}

	@Override
	public List<E> findAll() {
		return getRepository().findAll();
	}

	@Override
	public final Class<E> getEntityClass() {
		return entityClass;
	}

	/*
	 * Referência:
	 * https://www.it-swarm.net/pt/java/como-ignorar-valores-nulos-usando-
	 * springframework-beanutils-copyproperties/1043455506/
	 */
	protected String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<>();

		for (java.beans.PropertyDescriptor pd : pds) {
			if (pd.getReadMethod().isAnnotationPresent(Transient.class)) {
				continue;
			}
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}
