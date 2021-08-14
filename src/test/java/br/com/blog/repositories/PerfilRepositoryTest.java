package br.com.blog.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import br.com.blog.entities.Perfil;
import br.com.blog.enumerator.Roles;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class PerfilRepositoryTest {

	private Perfil perfil;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private PerfilRepository repository;

	@BeforeEach
	void init() {
		perfil = new Perfil();
		perfil.setRole(Roles.ADMIN);
	}

	@Test
	void testPerfilCount() {
		assertEquals(2, repository.count());
	}

	@Test
	void testFindAll() {
		assertEquals(2, repository.findAll().size());
	}

	@Test
	void testExistsByIdTrue() {
		assertTrue(repository.existsById(1L));
	}

	@Test
	void testExistsByIdFalse() {
		assertFalse(repository.existsById(99999L));
	}

	@Test
	void testFindById() {
		assertNotNull(repository.findById(1L).get());
	}

	@Test
	void testGetById() {
		Perfil Perfil = repository.getById(1L);
		assertEquals(Roles.ADMIN, Perfil.getRole());
	}

	@Test
	void testUpdate() {
		perfil = repository.getById(1L);
		perfil.setRole(Roles.USER);
		repository.save(perfil);
		Perfil perfilRetorno = repository.getById(1L);
		assertEquals(Roles.USER, perfilRetorno.getRole());
	}
	
}
