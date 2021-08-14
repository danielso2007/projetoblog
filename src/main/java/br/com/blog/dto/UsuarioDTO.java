package br.com.blog.dto;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UsuarioDTO extends BaseAuditDTO {

	private static final long serialVersionUID = -1100447355263113948L;

	@NotEmpty(message = "O nome não pode ser vazio")
	@NotNull(message = "O nome não pode ser nulo")
	@Length(min = 2, max = 400)
	private String nome;

	@NotEmpty(message = "O email não pode ser vazio")
	@NotNull(message = "O email não pode ser nulo")
	@Length(min = 10, max = 400)
	@Email
	private String email;

	@NotEmpty(message = "A senha não pode ser vazio")
	@NotNull(message = "A senha não pode ser nulo")
	@Length(min = 10, max = 100)
	private String senha;

	private Date ultimoAcesso;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String nome, String email, String senha, Date ultimoAcesso) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nome, senha, ultimoAcesso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UsuarioDTO)) {
			return false;
		}
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(ultimoAcesso, other.ultimoAcesso);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (senha != null ? "senha=" + senha + ", " : "")
				+ (ultimoAcesso != null ? "ultimoAcesso=" + ultimoAcesso : "") + "]";
	}

}
