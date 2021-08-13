package br.com.blog.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	private static final long ID = 1L;
	private static final String SENHA = "uwLF5ComxF";
	private static final String NOME = "Henrique Julio Assis";
	private static final String EMAIL = "hhenriquejulioassis@hubersuhner.com";

	private Usuario usuario;
	private Date dataUltimoAcesso;
	private Date dataCriacao;
	private Date dataAtualizacao;

	@BeforeEach
	void init() {
		dataUltimoAcesso = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataCriacao = Date.from(LocalDate.parse("2021-08-13").atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAtualizacao = Date.from(LocalDate.parse("2021-08-20").atStartOfDay(ZoneId.systemDefault()).toInstant());
		usuario = new Usuario().email(EMAIL).nome(NOME).senha(SENHA).ultimoAcesso(dataUltimoAcesso);
		usuario.setId(ID);
		usuario.setDataCriacao(dataCriacao);
		usuario.setDataAtualizacao(dataAtualizacao);
	}

	@Test
	void testCriandoUsuarioConstrutorPadrao() {
		usuario = new Usuario(NOME, EMAIL, SENHA, dataUltimoAcesso);
		assertEquals(NOME, usuario.getNome());
	}

	@Test
	void testCriandoUsuarioConstrutorPadraoComPostsEhAlbuns() {
		usuario = new Usuario(NOME, EMAIL, SENHA, dataUltimoAcesso, new HashSet<>(), new HashSet<>());
		assertEquals(EMAIL, usuario.getEmail());
	}

	@Test
	void testCriandoUsuarioConstrutorPadraoComPerfis() {
		usuario = new Usuario(NOME, EMAIL, SENHA, dataUltimoAcesso, Boolean.TRUE, new ArrayList<>());
		assertEquals(NOME, usuario.getNome());
	}

	@Test
	void testHashCodeDaClass() {
		int hash = usuario.hashCode();
		assertEquals(hash, usuario.hashCode());
	}

	@Test
	void testEqualsDaClassMesmoId() {
		Usuario usuarioTest = new Usuario().email(EMAIL).nome(NOME).senha(SENHA).ultimoAcesso(dataUltimoAcesso);
		usuarioTest.setId(ID);
		usuarioTest.setDataCriacao(dataCriacao);
		usuarioTest.setDataAtualizacao(dataAtualizacao);
		assertEquals(Boolean.TRUE, usuario.equals(usuarioTest));
	}
	
	@Test
	void testEqualsDaClassIdDiferenteEhNome() {
		Usuario usuarioTest = new Usuario().email(EMAIL).nome("Daniel").senha(SENHA).ultimoAcesso(dataUltimoAcesso);
		usuarioTest.setId(99L);
		usuarioTest.setDataCriacao(dataCriacao);
		usuarioTest.setDataAtualizacao(dataAtualizacao);
		assertEquals(Boolean.FALSE, usuario.equals(usuarioTest));
	}

	@Test
	void testEqualsDaClassMesmaInstancia() {
		Usuario usuarioTest = this.usuario;
		assertEquals(Boolean.TRUE, usuario.equals(usuarioTest));
	}

	@Test
	void testToStringTodosOsValores() {
		assertEquals(
				"Usuario [nome=Henrique Julio Assis, email=hhenriquejulioassis@hubersuhner.com, senha=uwLF5ComxF, ultimoAcesso="
						+ dataUltimoAcesso.toString() + ", getDataCriacao()=" + dataCriacao.toString()
						+ ", getDataAtualizacao()=" + dataAtualizacao.toString() + ", getId()=1]",
				usuario.toString());
	}

	@Test
	void testToStringdatUltimoAcessoNuloEhDataAtualizacaoNula() {
		usuario.setUltimoAcesso(null);
		usuario.setDataAtualizacao(null);
		assertEquals(
				"Usuario [nome=Henrique Julio Assis, email=hhenriquejulioassis@hubersuhner.com, senha=uwLF5ComxF, getDataCriacao()="
						+ dataCriacao.toString() + ", getId()=1]",
				usuario.toString());
	}

}
