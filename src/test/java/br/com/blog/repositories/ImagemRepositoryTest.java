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

import br.com.blog.entities.Imagem;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class ImagemRepositoryTest {

	private static final String ARQUIVO = "vistamorro-1280x640.jpg";
	private static final String TITULO = "Vel fermentum facilisis";
	private static final String PATH = "http://www.construtoraconcisa.com.br/blog/wp-content/uploads/2019/10/vistamorro-1280x640.jpg";

	private Imagem imagem;
	private Date dataCriacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private ImagemRepository repository;
	
	@Autowired
	private PostRepository postRepository;

	@BeforeEach
	void init() {
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		imagem = new Imagem().arquivo(ARQUIVO).titulo(TITULO).path(PATH).dataCriacao(dataCriacao);
	}

	@Test
	void testimagemCount() {
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
		Imagem imagem = repository.getById(1L);
		assertEquals("Platea donec faucibus", imagem.getTitulo());
	}

	@Test
	void testSave() {
		imagem.setPost(postRepository.getById(1L));
		imagem = repository.save(imagem);
		assertNotNull(imagem.getId());
	}
	
	@Test
	void testUpdate() {
		final String value = "kjasgdJASHGDJHASD";
		imagem = repository.getById(1L);
		imagem.setTitulo(value);;
		repository.save(imagem);
		Imagem imagemRetorno = repository.getById(1L);
		assertEquals(value, imagemRetorno.getTitulo());
	}
	
}
