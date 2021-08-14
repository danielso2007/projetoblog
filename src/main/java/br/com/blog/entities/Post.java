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
@Table(name = "post", schema = "public", indexes = { @Index(name = "indexPostUsuarioId", columnList = "id_usuario") })
public class Post extends BaseAudit {

	private static final long serialVersionUID = -7734360614636797536L;

	@NotEmpty(message = "O texto do post não pode ser vazio")
	@NotNull(message = "O texto do post não pode ser nulo")
	@Length(min = 1, max = 600)
	@Column(length = 600, nullable = false)
	private String texto;

	@NotNull(message = "O usuário não pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comentario> comentarios;

	@OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Imagem> imagens;

	public Post() {
	}

	public Post(String texto, Usuario usuario) {
		this.texto = texto;
		this.usuario = usuario;
	}

	public Post(String texto, Usuario usuario, Set<Imagem> imagens) {
		this.texto = texto;
		this.usuario = usuario;
		this.imagens = imagens;
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

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(Set<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Post texto(String texto) {
		setTexto(texto);
		return this;
	}

	public Post usuario(Usuario usuario) {
		setUsuario(usuario);
		return this;
	}

	public Post comentarios(Set<Comentario> comentarios) {
		setComentarios(comentarios);
		return this;
	}

	public Post imagens(Set<Imagem> imagens) {
		setImagens(imagens);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(texto, usuario);
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
		if (!(obj instanceof Post)) {
			return false;
		}
		Post other = (Post) obj;
		return Objects.equals(texto, other.texto) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Post [" + (texto != null ? "texto=" + texto + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (imagens != null ? "imagens=" + imagens + ", " : "")
				+ (getDataCriacao() != null ? "getDataCriacao()=" + getDataCriacao() + ", " : "")
				+ (getDataAtualizacao() != null ? "getDataAtualizacao()=" + getDataAtualizacao() + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
