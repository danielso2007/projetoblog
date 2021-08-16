package br.com.blog.security.jwt;

import java.io.Serializable;
import java.util.Objects;

public class JwtAuthenticationRequest implements Serializable {

	private static final long serialVersionUID = -9169999783360713211L;

	private String email;
	private String password;

	public JwtAuthenticationRequest() {
	}

	public JwtAuthenticationRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtAuthenticationRequest email(String email) {
		setEmail(email);
		return this;
	}

	public JwtAuthenticationRequest password(String password) {
		setPassword(password);
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof JwtAuthenticationRequest)) {
			return false;
		}
		JwtAuthenticationRequest other = (JwtAuthenticationRequest) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequest [" + (email != null ? "email=" + email + ", " : "")
				+ (password != null ? "password=" + password : "") + "]";
	}

}
