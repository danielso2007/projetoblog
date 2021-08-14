package br.com.blog.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AlbumDTO extends BaseAuditDTO {

	private static final long serialVersionUID = 4244308577837757228L;

	@NotEmpty(message = "O título não pode ser vazio")
	@NotNull(message = "O título não pode ser nulo")
	@Length(min = 1, max = 200)
	private String titulo;

	@NotEmpty(message = "A descrição não pode ser vazio")
	@Length(max = 600)
	private String descricao;

	public AlbumDTO() {
	}

	public AlbumDTO(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
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

	public AlbumDTO titulo(String titulo) {
		setTitulo(titulo);
		return this;
	}

	public AlbumDTO descricao(String descricao) {
		setDescricao(descricao);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(descricao, titulo);
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
		if (!(obj instanceof AlbumDTO)) {
			return false;
		}
		AlbumDTO other = (AlbumDTO) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "AlbumDTO [" + (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
