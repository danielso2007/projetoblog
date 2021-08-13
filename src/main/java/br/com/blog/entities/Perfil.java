package br.com.blog.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import br.com.blog.enumerator.Roles;

@Entity
@Table(name = "perfil", schema = "public", indexes = {
		@Index(name = "indexPerfilNome", columnList = "nome") }, uniqueConstraints = @UniqueConstraint(name = "uniquePerfilNOme", columnNames = "nome"))
public class Perfil extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = -2787795722974071762L;

	@NotNull(message = "O nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min = 5, max = 20, message = "O nome deve ter no mínimo 5 caracteres")
	@Column(name = "nome", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Roles role;

	public Perfil() {
	}

	public Perfil(Roles role) {
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
		if (!(obj instanceof Perfil)) {
			return false;
		}
		Perfil other = (Perfil) obj;
		return role == other.role;
	}

	@Override
	public String toString() {
		return "Perfil [" + (role != null ? "nome=" + role + ", " : "") + (getId() != null ? "getId()=" + getId() : "")
				+ "]";
	}

}
