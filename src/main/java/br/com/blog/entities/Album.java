package br.com.blog.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "album", schema = "public", indexes = { @Index(name = "indexAlbumUsuarioId", columnList = "id_usuario") })
public class Album extends BaseAudit {

	private static final long serialVersionUID = 2172650830113466883L;

	@NotEmpty(message = "O título não pode ser vazio")
	@NotNull(message = "O título não pode ser nulo")
	@Length(min = 1, max = 200)
	@Column(length = 200, nullable = false)
	private String titulo;
	@NotEmpty(message = "A descrição não pode ser vazio")
	@Length(max = 600)
	@Column(length = 600)
	private String descricao;
	@NotNull(message = "O usuário não pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	@OneToMany(mappedBy = "album", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Foto> fotos;

	public Album() {
	}

	public Album(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Album(String titulo, String descricao, Usuario usuario) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
	}

	public Album(String titulo, String descricao, Usuario usuario, Set<Foto> fotos) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
		this.fotos = fotos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(descricao, titulo, usuario);
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
		if (!(obj instanceof Album)) {
			return false;
		}
		Album other = (Album) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(titulo, other.titulo)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Album [" + (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (getDataCriacao() != null ? "getDataCriacao()=" + getDataCriacao() + ", " : "")
				+ (getDataAtualizacao() != null ? "getDataAtualizacao()=" + getDataAtualizacao() + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
