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

import br.com.blog.entities.Comentario;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class ComentarioRepositoryTest {

	private static final String TEXTO = "Aenean egestas nec vehicula habitasse proin";
	private Comentario comentario;
	private Date dataCriacao;
	private Date dataAtualizacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private ComentarioRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostRepository postRepository;

	@BeforeEach
	void init() {
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAtualizacao = Date.from(LocalDate.parse("2021-08-20").atStartOfDay(ZoneId.systemDefault()).toInstant());
		comentario = new Comentario().texto(TEXTO);
		comentario.setDataCriacao(dataCriacao);
		comentario.setDataAtualizacao(dataAtualizacao);
	}

	@Test
	void testcomentarioCount() {
		assertEquals(9, repository.count());
	}

	@Test
	void testFindAll() {
		assertEquals(9, repository.findAll().size());
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
		Comentario comentario = repository.getById(1L);
		assertEquals("Aenean egestas nec vehicula habitasse proin, pharetra nec gravida quisque.", comentario.getTexto());
	}

	@Test
	void testSave() {
		comentario.setUsuario(usuarioRepository.getById(1L));
		comentario.setPost(postRepository.getById(1L));
		comentario = repository.save(comentario);
		assertNotNull(comentario.getId());
	}
	
	@Test
	void testUpdate() {
		final String value = "askljdlçakj lkasjdçlsajdçlsad";
		comentario = repository.getById(1L);
		comentario.setTexto(value);
		repository.save(comentario);
		Comentario comentarioRetorno = repository.getById(1L);
		assertEquals(value, comentarioRetorno.getTexto());
	}
	
}
