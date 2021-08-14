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

import br.com.blog.entities.Post;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class PostRepositoryTest {

	private static final String TEXTO = "Pellentesque commodo litora libero etiam sollicitudin curabitur faucibus fringilla malesuada";
	private Post post;
	private Date dataCriacao;
	private Date dataAtualizacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private PostRepository repository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeEach
	void init() {
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAtualizacao = Date.from(LocalDate.parse("2021-08-20").atStartOfDay(ZoneId.systemDefault()).toInstant());
		post = new Post().texto(TEXTO);
		post.setDataCriacao(dataCriacao);
		post.setDataAtualizacao(dataAtualizacao);
	}

	@Test
	void testpostCount() {
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
		Post post = repository.getById(1L);
		assertEquals(
				"Massa ultrices per tincidunt eu aliquet ut lectus, metus odio metus rhoncus purus luctus, ad hendrerit tincidunt lobortis placerat felis.",
				post.getTexto());
	}

	@Test
	void testSave() {
		post.usuario(usuarioRepository.getById(1L));
		post = repository.save(post);
		assertNotNull(post.getId());
	}

	@Test
	void testUpdate() {
		final String value = "Shdaksjdh Dhaksjdh Iuqwjlasdkjsa";
		post = repository.getById(1L);
		post.setTexto(value);
		repository.save(post);
		Post postRetorno = repository.getById(1L);
		assertEquals(value, postRetorno.getTexto());
	}

}
