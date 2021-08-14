package br.com.blog.enumerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste do Enum Roles")
class RolesTest {

	@Test
	@DisplayName("Role Admin")
	void testGetDescricaoAdmin() {
		assertEquals("Administrador", Roles.ADMIN.getDescription());
	}
	
	@Test
	@DisplayName("Role User")
	void testGetDescricaoUser() {
		assertEquals("Usuário", Roles.USER.getDescription());
	}
	
}
