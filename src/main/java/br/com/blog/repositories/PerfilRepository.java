package br.com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}