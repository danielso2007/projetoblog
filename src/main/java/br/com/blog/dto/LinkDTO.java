package br.com.blog.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class LinkDTO extends BaseAuditDTO {

	private static final long serialVersionUID = -2832819320099116064L;

	@NotEmpty(message = "O título não pode ser vazio")
	@Length(max = 200)
	private String titulo;

	@NotEmpty(message = "A url não pode ser vazio")
	@NotNull(message = "A url não pode ser nulo")
	@Length(max = 600)
	private String url;

	public LinkDTO() {
	}

	public LinkDTO(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
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

	public LinkDTO titulo(String titulo) {
		setTitulo(titulo);
		return this;
	}

	public LinkDTO url(String url) {
		setUrl(url);
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
		if (!(obj instanceof LinkDTO)) {
			return false;
		}
		LinkDTO other = (LinkDTO) obj;
		return Objects.equals(titulo, other.titulo) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "LinkDTO [" + (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (url != null ? "url=" + url + ", " : "")
				+ (getDataCriacao() != null ? "getDataCriacao()=" + getDataCriacao() + ", " : "")
				+ (getDataAtualizacao() != null ? "getDataAtualizacao()=" + getDataAtualizacao() + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
