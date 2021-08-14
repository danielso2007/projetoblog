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

import br.com.blog.entities.Link;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class LinkRepositoryTest {

	private static final String TITULO = "Como fazer um blog de viagem do zero (6 passos)";
	private static final String URL = "https://www.hostinger.com.br/tutoriais/como-fazer-um-blog-de-viagem";
	private Link link;
	private Date dataCriacao;
	private Date dataAtualizacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private LinkRepository repository;

	@Autowired
	private PostRepository postRepository;

	@BeforeEach
	void init() {
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAtualizacao = Date.from(LocalDate.parse("2021-08-20").atStartOfDay(ZoneId.systemDefault()).toInstant());
		link = new Link().titulo(TITULO).url(URL);
		link.setDataCriacao(dataCriacao);
		link.setDataAtualizacao(dataAtualizacao);
	}

	@Test
	void testlinkCount() {
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
		Link link = repository.getById(1L);
		assertEquals("https://www.viagem20.com.br/paginas-textuais/videos-1", link.getUrl());
	}

	@Test
	void testSave() {
		link.post(postRepository.getById(1L));
		link = repository.save(link);
		assertNotNull(link.getId());
	}

	@Test
	void testUpdate() {
		final String value = "ASKDJH askdjhaskj hj";
		link = repository.getById(1L);
		link.setTitulo(value);
		repository.save(link);
		Link linkRetorno = repository.getById(1L);
		assertEquals(value, linkRetorno.getTitulo());
	}

}
