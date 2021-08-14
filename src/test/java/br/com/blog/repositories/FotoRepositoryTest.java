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

import br.com.blog.entities.Foto;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class FotoRepositoryTest {

	private static final String PATH = "https://cdn6.campograndenews.com.br/uploads/noticias/2020/03/10/20thykzikzvos.jpg";
	private static final String ARQUIVO = "20thykzikzvos.jpg";
	private Foto foto;
	private Date dataCriacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private FotoRepository repository;
	
	@Autowired
	private AlbumRepository albumRepository;

	@BeforeEach
	void init() {
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		foto = new Foto().arquivo(ARQUIVO).path(PATH).dataCriacao(dataCriacao);
		foto.setDataCriacao(dataCriacao);
	}

	@Test
	void testfotoCount() {
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
		Foto foto = repository.getById(1L);
		assertEquals("20thykzikzvos.jpg", foto.getArquivo());
	}

	@Test
	void testSave() {
		foto = foto.album(albumRepository.getById(1L));
		foto = repository.save(foto);
		assertNotNull(foto.getId());
	}
	
	@Test
	void testUpdate() {
		final String value = "arquivo";
		foto = repository.getById(1L);
		foto.setArquivo(value);
		repository.save(foto);
		Foto fotoRetorno = repository.getById(1L);
		assertEquals(value, fotoRetorno.getArquivo());
	}
	
}
