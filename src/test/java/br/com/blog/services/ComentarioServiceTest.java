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

import br.com.blog.entities.Comentario;
import br.com.blog.repositories.ComentarioRepository;
import br.com.blog.services.impl.ComentarioServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class ComentarioServiceTest {

	@InjectMocks @Spy
	private ComentarioServiceImpl service;
	
	@Mock
	private ComentarioRepository repository;
	
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
		Optional<Comentario> retorno = Optional.of(new Comentario());
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
		Comentario comentario = new Comentario();
		comentario.setId(1L);
		doReturn(comentario).when(repository).save(comentario);
		assertTrue(service.save(comentario).isPresent());
	}
	
	@Test
	void testUpdateEntidadeNula() {
		assertThrows(IllegalArgumentException.class, () -> service.update(null, 1L));
	}
	
	@Test
	void testUpdateEntidadeNaoExiste() {
		Long id = 99L;
		Comentario comentario = new Comentario();
		comentario.setId(id);
		doReturn(Optional.empty()).when(repository).findById(id);
		assertEquals(Optional.empty(), service.update(comentario, id));
	}
	
	@Test
	void testUpdate() {
		Long id = 99L;
		Comentario comentario = new Comentario();
		comentario.setId(id);
		Optional<Comentario> retorno = Optional.of(comentario);
		doReturn(retorno).when(repository).findById(id);
		doReturn(comentario).when(repository).save(comentario);
		assertTrue(service.update(comentario, id).isPresent());
	}
	
	@Test
	void testFindAll() {
		Comentario comentario = new Comentario();
		List<Comentario> retornoLista = new ArrayList<>();
		retornoLista.add(comentario);
		doReturn(retornoLista).when(repository).findAll();
		assertEquals(1, service.findAll().size());
	}
	
	@Test
	void testGetEntityClass() {
		assertEquals(Comentario.class, service.getEntityClass());
	}
	
}
