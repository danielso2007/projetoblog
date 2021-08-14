package br.com.blog.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "comentario", schema = "public", indexes = {
		@Index(name = "indexComentarioPostId", columnList = "id_post"),
		@Index(name = "indexComentarioUsuarioId", columnList = "id_usuario") })
public class Comentario extends BaseAudit {

	private static final long serialVersionUID = -8063543202575494822L;

	@NotEmpty(message = "O texto do comentário não pode ser vazio")
	@NotNull(message = "O texto do comentário não pode ser nulo")
	@Length(min = 1, max = 300)
	@Column(length = 300, nullable = false)
	private String texto;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_post", nullable = false)
	private Post post;

	public Comentario() {
	}

	public Comentario(String texto) {
		this.texto = texto;
	}

	public Comentario(String texto, Usuario usuario, Post post) {
		this.texto = texto;
		this.usuario = usuario;
		this.post = post;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comentario texto(String texto) {
		setTexto(texto);
		return this;
	}

	public Comentario usuario(Usuario usuario) {
		setUsuario(usuario);
		return this;
	}

	public Comentario post(Post post) {
		setPost(post);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(texto);
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
		if (!(obj instanceof Comentario)) {
			return false;
		}
		Comentario other = (Comentario) obj;
		return Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Comentario [" + (texto != null ? "texto=" + texto + ", " : "")
				+ (getDataCriacao() != null ? "getDataCriacao()=" + getDataCriacao() + ", " : "")
				+ (getDataAtualizacao() != null ? "getDataAtualizacao()=" + getDataAtualizacao() + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
