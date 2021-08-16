package br.com.blog.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.blog.enumerator.Roles;

class PerfilTest {

	private static final long ID = 1L;
	private Perfil perfil;

	@BeforeEach
	void init() {
		perfil = new Perfil();
		perfil.setId(ID);
		perfil.setRole(Roles.USER);
	}

	@Test
	void testCriandoPerfilConstrutorParaRoles() {
		perfil = new Perfil(Roles.ADMIN);
		assertEquals(Roles.ADMIN, perfil.getRole());
	}

	@Test
	void testCriandoPerfilConstrutorPadrao() {
		perfil = new Perfil();
		perfil.setRole(Roles.USER);
		assertEquals(Roles.USER, perfil.getRole());
	}

	@Test
	void testCriandoPerfilObtendoDescricao() {
		assertEquals("Usuário", perfil.descricao());
	}
	
	@Test
	void testAuthority() {
		assertEquals("USER", perfil.getAuthority());
	}

	@Test
	void testHashCode() {
		// Precisamos testar o hashCode?!?!? 
		int hash = perfil.hashCode();
		assertEquals(hash, perfil.hashCode());
	}

	@Test
	void testEquals() {
		Perfil perfilTest = new Perfil();
		perfilTest.setId(ID);
		perfilTest.setRole(Roles.USER);
		assertEquals(Boolean.TRUE, perfil.equals(perfilTest));
	}

	@Test
	void testEqualsDiferentes() {
		Perfil perfilTest = new Perfil();
		perfilTest.setId(213L);
		perfilTest.setRole(Roles.ADMIN);
		assertEquals(Boolean.FALSE, perfil.equals(perfilTest));
	}

	@Test
	void testToString() {
		assertEquals("USER", perfil.toString());
	}
	
}
