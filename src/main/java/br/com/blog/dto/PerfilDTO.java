package br.com.blog.dto;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import br.com.blog.enumerator.Roles;

public class PerfilDTO extends BaseEntityDTO implements GrantedAuthority {

	private static final long serialVersionUID = -7914616650931419742L;

	private Roles role;

	public PerfilDTO() {
	}

	public PerfilDTO(Roles role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role.toString();
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String descricao() {
		return role.getDescription();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(role);
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
		if (!(obj instanceof PerfilDTO)) {
			return false;
		}
		PerfilDTO other = (PerfilDTO) obj;
		return role == other.role;
	}

	@Override
	public String toString() {
		return "PerfilDTO [" + (role != null ? "role=" + role + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
