package br.com.blog.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.blog.entities.Imagem;
import br.com.blog.repositories.ImagemRepository;
import br.com.blog.services.impl.ImagemServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class ImagemServiceTest {

	@InjectMocks @Spy
	private ImagemServiceImpl service;
	
	@Mock
	private ImagemRepository repository;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetUser() {
		UserDetails user = service.getUser();
		assertEquals("Anonymous", user.getUsername());
	}
	
	@Test
	void testGetRepository() {
		when(service.getRepository()).thenReturn(repository);
		assertNotNull(service.getRepository());
	}
	
	@Test
	void testDelete() {
		service.delete(1L);
		verify(service, times(1)).delete(1L);
	}
	
	@Test
	void testFindByIdNull() {
		assertEquals(Optional.empty(), service.findById(null));
	}
	
	@Test
	void testFindById() {
		Optional<Imagem> retorno = Optional.of(new Imagem());
		Long id = 10L;
		doReturn(retorno).when(repository).findById(id);
		assertTrue(service.findById(id).isPresent());
	}
	
	@Test
	void testSaveObjectNull() {
		assertEquals(Optional.empty(), service.save(null));
	}
	
	@Test
	void testSave() {
		Imagem imagem = new Imagem();
		imagem.setId(1L);
		doReturn(imagem).when(repository).save(imagem);
		assertTrue(service.save(imagem).isPresent());
	}
	
	@Test
	void testUpdateEntidadeNula() {
		assertThrows(IllegalArgumentException.class, () -> service.update(null, 1L));
	}
	
	@Test
	void testUpdateEntidadeNaoExiste() {
		Long id = 99L;
		Imagem imagem = new Imagem();
		imagem.setId(id);
		doReturn(Optional.empty()).when(repository).findById(id);
		assertEquals(Optional.empty(), service.update(imagem, id));
	}
	
	@Test
	void testUpdate() {
		Long id = 99L;
		Imagem imagem = new Imagem();
		imagem.setId(id);
		Optional<Imagem> retorno = Optional.of(imagem);
		doReturn(retorno).when(repository).findById(id);
		doReturn(imagem).when(repository).save(imagem);
		assertTrue(service.update(imagem, id).isPresent());
	}
	
	@Test
	void testFindAll() {
		Imagem imagem = new Imagem();
		List<Imagem> retornoLista = new ArrayList<>();
		retornoLista.add(imagem);
		doReturn(retornoLista).when(repository).findAll();
		assertEquals(1, service.findAll().size());
	}
	
	@Test
	void testGetEntityClass() {
		assertEquals(Imagem.class, service.getEntityClass());
	}
	
}
