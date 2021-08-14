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

import br.com.blog.entities.Link;
import br.com.blog.repositories.LinkRepository;
import br.com.blog.services.impl.LinkServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class LinkServiceTest {

	@InjectMocks @Spy
	private LinkServiceImpl service;
	
	@Mock
	private LinkRepository repository;
	
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
		Optional<Link> retorno = Optional.of(new Link());
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
		Link link = new Link();
		link.setId(1L);
		doReturn(link).when(repository).save(link);
		assertTrue(service.save(link).isPresent());
	}
	
	@Test
	void testUpdateEntidadeNula() {
		assertThrows(IllegalArgumentException.class, () -> service.update(null, 1L));
	}
	
	@Test
	void testUpdateEntidadeNaoExiste() {
		Long id = 99L;
		Link link = new Link();
		link.setId(id);
		doReturn(Optional.empty()).when(repository).findById(id);
		assertEquals(Optional.empty(), service.update(link, id));
	}
	
	@Test
	void testUpdate() {
		Long id = 99L;
		Link link = new Link();
		link.setId(id);
		Optional<Link> retorno = Optional.of(link);
		doReturn(retorno).when(repository).findById(id);
		doReturn(link).when(repository).save(link);
		assertTrue(service.update(link, id).isPresent());
	}
	
	@Test
	void testFindAll() {
		Link link = new Link();
		List<Link> retornoLista = new ArrayList<>();
		retornoLista.add(link);
		doReturn(retornoLista).when(repository).findAll();
		assertEquals(1, service.findAll().size());
	}
	
	@Test
	void testGetEntityClass() {
		assertEquals(Link.class, service.getEntityClass());
	}
	
}
