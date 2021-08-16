package br.com.blog.security.model;

import java.util.Objects;

import br.com.blog.entities.Usuario;
import br.com.blog.security.jwt.JwtUser;
import br.com.blog.security.jwt.JwtUserFactory;

public class CurrentUser {

	private String token;
	private JwtUser user;

	public CurrentUser() {
	}

	public CurrentUser(String token, Usuario user) {
		this.token = token;
		this.user = JwtUserFactory.create(user);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtUser getUser() {
		return user;
	}

	public void setUser(JwtUser user) {
		this.user = user;
	}

	public CurrentUser token(String token) {
		setToken(token);
		return this;
	}

	public CurrentUser user(JwtUser user) {
		setUser(user);
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(token, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CurrentUser)) {
			return false;
		}
		CurrentUser other = (CurrentUser) obj;
		return Objects.equals(token, other.token) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "CurrentUser [" + (token != null ? "token=" + token + ", " : "") + (user != null ? "user=" + user : "")
				+ "]";
	}

}
