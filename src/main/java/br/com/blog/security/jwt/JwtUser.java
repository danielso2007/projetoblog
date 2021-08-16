package br.com.blog.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = -2171871733382847923L;

	@JsonIgnore
	private Long id;
	private String nome;
	private String email;
	@JsonIgnore
	private String senha;
	private Boolean enabled;
	private List<String> roles;
	@JsonIgnore
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUser() {
	}

	public JwtUser(Long id, String nome, String email, String senha, Boolean enabled) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.enabled = enabled;
	}

	public JwtUser(Long id, String nome, String email, String senha, Boolean enabled,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.enabled = enabled;
		this.authorities = authorities;
		this.roles = getRoles();
	}

	public JwtUser(Long id, String nome, String email, String senha, Boolean enabled, List<String> roles,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.enabled = enabled;
		this.roles = roles;
		this.authorities = authorities;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getRoles() {
		this.roles = new ArrayList<>();
		if (this.authorities == null) {
			return Collections.emptyList();
		}
		this.authorities.forEach(authority -> this.roles.add(((SimpleGrantedAuthority) authority).getAuthority()));
		return this.roles;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public JwtUser id(Long id) {
		setId(id);
		return this;
	}

	public JwtUser nome(String nome) {
		setNome(nome);
		return this;
	}

	public JwtUser email(String email) {
		setEmail(email);
		return this;
	}

	public JwtUser senha(String senha) {
		setSenha(senha);
		return this;
	}

	public JwtUser enabled(Boolean enabled) {
		setEnabled(enabled);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, enabled, id, nome, senha);
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
		if (!(obj instanceof JwtUser)) {
			return false;
		}
		JwtUser other = (JwtUser) obj;
		return Objects.equals(email, other.email) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "JwtUser [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (senha != null ? "senha=" + senha + ", " : "")
				+ (enabled != null ? "enabled=" + enabled : "") + "]";
	}

}
