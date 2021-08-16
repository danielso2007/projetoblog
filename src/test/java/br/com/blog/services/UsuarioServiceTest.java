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

import br.com.blog.entities.Usuario;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.impl.UsuarioServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class UsuarioServiceTest {

	@InjectMocks @Spy
	private UsuarioServiceImpl service;
	
	@Mock
	private UsuarioRepository repository;
	
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
		Optional<Usuario> retorno = Optional.of(new Usuario());
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
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		doReturn(usuario).when(repository).save(usuario);
		assertTrue(service.save(usuario).isPresent());
	}
	
	@Test
	void testUpdateEntidadeNula() {
		assertThrows(IllegalArgumentException.class, () -> service.update(null, 1L));
	}
	
	@Test
	void testUpdateEntidadeNaoExiste() {
		Long id = 99L;
		Usuario usuario = new Usuario();
		usuario.setId(id);
		doReturn(Optional.empty()).when(repository).findById(id);
		assertEquals(Optional.empty(), service.update(usuario, id));
	}
	
	@Test
	void testUpdate() {
		Long id = 99L;
		Usuario usuario = new Usuario();
		usuario.setId(id);
		Optional<Usuario> retorno = Optional.of(usuario);
		doReturn(retorno).when(repository).findById(id);
		doReturn(usuario).when(repository).save(usuario);
		assertTrue(service.update(usuario, id).isPresent());
	}
	
	@Test
	void testFindAll() {
		Usuario usuario = new Usuario();
		List<Usuario> retornoLista = new ArrayList<>();
		retornoLista.add(usuario);
		doReturn(retornoLista).when(repository).findAll();
		assertEquals(1, service.findAll().size());
	}
	
	@Test
	void testGetEntityClass() {
		assertEquals(Usuario.class, service.getEntityClass());
	}
	
}
