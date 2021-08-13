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
@Table(name = "link", schema = "public", indexes = { @Index(name = "indexLinkPostId", columnList = "id_post") })
public class Link extends BaseAudit {

	private static final long serialVersionUID = 1918784227933327559L;

	@NotEmpty(message = "O título não pode ser vazio")
	@Length(max = 200)
	@Column(length = 200)
	private String titulo;
	@NotEmpty(message = "A url não pode ser vazio")
	@NotNull(message = "A url não pode ser nulo")
	@Length(max = 600)
	@Column(length = 600, nullable = false)
	private String url;
	@NotNull(message = "O post não pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "id_post", nullable = false)
	private Post post;

	public Link() {
	}

	public Link(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
	}

	public Link(String titulo, String url, Post post) {
		this.titulo = titulo;
		this.url = url;
		this.post = post;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Link titulo(String titulo) {
		setTitulo(titulo);
		return this;
	}

	public Link url(String url) {
		setUrl(url);
		return this;
	}

	public Link post(Post post) {
		setPost(post);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(titulo, url);
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
		if (!(obj instanceof Link)) {
			return false;
		}
		Link other = (Link) obj;
		return Objects.equals(titulo, other.titulo) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Link [titulo=" + titulo + ", url=" + url + ", getDataCriacao()=" + getDataCriacao()
				+ ", getDataAtualizacao()=" + getDataAtualizacao() + ", getId()=" + getId() + "]";
	}

}
