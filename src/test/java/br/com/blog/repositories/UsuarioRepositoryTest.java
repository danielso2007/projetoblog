package br.com.blog.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import br.com.blog.entities.Usuario;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class UsuarioRepositoryTest {

	private static final String SENHA = "uwLF5ComxFasdasdsadgdhdg";
	private static final String NOME = "Henrique Julio Assis";
	private static final String EMAIL = "hhenriquejulioassis@hubersuhner.com";

	private Usuario usuario;
	private Date dataUltimoAcesso;
	private Date dataCriacao;
	private Date dataAtualizacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private UsuarioRepository repository;

	@BeforeEach
	void init() {
		dataUltimoAcesso = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAtualizacao = Date.from(LocalDate.parse("2021-08-20").atStartOfDay(ZoneId.systemDefault()).toInstant());
		usuario = new Usuario().email(EMAIL).nome(NOME).senha(SENHA).ultimoAcesso(dataUltimoAcesso);
		usuario.setDataCriacao(dataCriacao);
		usuario.setDataAtualizacao(dataAtualizacao);
	}

	@Test
	void testUsuarioCount() {
		assertEquals(5, repository.count());
	}

	@Test
	void testFindAll() {
		assertEquals(5, repository.findAll().size());
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
		Usuario usuario = repository.getById(1L);
		assertEquals("Administrador", usuario.getNome());
	}

	@Test
	void testSave() {
		usuario = repository.save(usuario);
		assertNotNull(usuario.getId());
	}
	
	@Test
	void testUpdate() {
		final String value = "Daniel";
		usuario = repository.getById(1L);
		usuario.setNome(value);
		repository.save(usuario);
		Usuario usuarioRetorno = repository.getById(1L);
		assertEquals(value, usuarioRetorno.getNome());
	}
	
}
