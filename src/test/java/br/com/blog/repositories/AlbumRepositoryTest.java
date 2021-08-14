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

import br.com.blog.entities.Album;
import br.com.blog.testlifecyclemanager.CustomPostgresContainer;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
@Transactional
class AlbumRepositoryTest {

	private static final String TITULO = "Henrique Julio Assis";
	private static final String DESCRICAO = "hhenriquejulioassis@hubersuhner.com";

	private Album album;
	private Date dataCriacao;
	private Date dataAtualizacao;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = CustomPostgresContainer.getInstance();

	@Autowired
	private AlbumRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeEach
	void init() {
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAtualizacao = Date.from(LocalDate.parse("2021-08-20").atStartOfDay(ZoneId.systemDefault()).toInstant());
		album = new Album().titulo(TITULO).descricao(DESCRICAO);
		album.setDataCriacao(dataCriacao);
		album.setDataAtualizacao(dataAtualizacao);
		
	}

	@Test
	void testAlbumCount() {
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
		Album Album = repository.getById(1L);
		assertEquals("Ante consectetur lorem", Album.getTitulo());
	}

	@Test
	void testSave() {
		album.setUsuario(usuarioRepository.getById(1L));
		album = repository.save(album);
		assertNotNull(album.getId());
	}
	
	@Test
	void testUpdate() {
		final String titulo = "ipsum hendrerit";
		album = repository.getById(1L);
		album.setTitulo(titulo);
		repository.save(album);
		Album AlbumRetorno = repository.getById(1L);
		assertEquals(titulo, AlbumRetorno.getTitulo());
	}
	
}
