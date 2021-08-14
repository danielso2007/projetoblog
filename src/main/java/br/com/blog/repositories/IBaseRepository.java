package br.com.blog.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.blog.entities.BaseEntity;

/**
 * O repositório base da aplicação.
 *
 * @param <E>  A entidade.
 * @param <K> O tipo da identificação das entidades.
 */
@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity, I extends Serializable> extends JpaRepository<T, I> {
}
