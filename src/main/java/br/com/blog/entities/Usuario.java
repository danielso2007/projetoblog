package br.com.blog.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuario", schema = "public", indexes = {
		@Index(name = "indexUsuarioEmail", columnList = "email") }, uniqueConstraints = @UniqueConstraint(name = "uniqueUsurioEmail", columnNames = "email"))
public class Usuario extends BaseAudit implements UserDetails {

	private static final long serialVersionUID = 1384980122479633418L;

	@NotEmpty(message = "O nome não pode ser vazio")
	@NotNull(message = "O nome não pode ser nulo")
	@Length(min = 2, max = 400)
	@Column(length = 400, nullable = false)
	private String nome;

	@NotEmpty(message = "O email não pode ser vazio")
	@NotNull(message = "O email não pode ser nulo")
	@Length(min = 10, max = 400)
	@Column(length = 400, nullable = false)
	@Email
	private String email;

	@NotEmpty(message = "A senha não pode ser vazio")
	@NotNull(message = "A senha não pode ser nulo")
	@Length(min = 10, max = 100)
	@Column(length = 100, nullable = false)
	private String senha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_acesso", nullable = true)
	private Date ultimoAcesso;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled = Boolean.TRUE;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Post> posts;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Album> albuns;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comentario> comentarios;

	@ManyToMany
	private List<Perfil> perfis;

	public Usuario() {
	}

	public Usuario(String nome, String email, String senha, Date ultimoAcesso) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ultimoAcesso = ultimoAcesso;
	}

	public Usuario(String nome, String email, String senha, Date ultimoAcesso, Set<Post> posts, Set<Album> albuns) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ultimoAcesso = ultimoAcesso;
		this.posts = posts;
		this.albuns = albuns;
	}

	public Usuario(String nome, String email, String senha, Date ultimoAcesso, Boolean enabled, List<Perfil> perfis) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ultimoAcesso = ultimoAcesso;
		this.enabled = enabled;
		this.perfis = perfis;
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

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(Set<Album> albuns) {
		this.albuns = albuns;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Usuario nome(String nome) {
		setNome(nome);
		return this;
	}

	public Usuario email(String email) {
		setEmail(email);
		return this;
	}

	public Usuario senha(String senha) {
		setSenha(senha);
		return this;
	}

	public Usuario ultimoAcesso(Date ultimoAcesso) {
		setUltimoAcesso(ultimoAcesso);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, nome, senha, ultimoAcesso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		return Objects.equals(getId(), other.getId()) && Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(ultimoAcesso, other.ultimoAcesso);
	}

	@Override
	public String toString() {
		return "Usuario [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (senha != null ? "senha=" + senha + ", " : "")
				+ (ultimoAcesso != null ? "ultimoAcesso=" + ultimoAcesso + ", " : "")
				+ (posts != null ? "posts=" + posts + ", " : "")
				+ (getDataCriacao() != null ? "getDataCriacao()=" + getDataCriacao() + ", " : "")
				+ (getDataAtualizacao() != null ? "getDataAtualizacao()=" + getDataAtualizacao() + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

	// CAMPOS DO SPRING SECURITY

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerfis();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isAccountNonLocked() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
