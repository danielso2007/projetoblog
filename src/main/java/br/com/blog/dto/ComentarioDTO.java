package br.com.blog.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ComentarioDTO extends BaseAuditDTO {

	private static final long serialVersionUID = -1588942832947423702L;

	@NotEmpty(message = "O texto do comentário não pode ser vazio")
	@NotNull(message = "O texto do comentário não pode ser nulo")
	@Length(min = 1, max = 300)
	private String texto;

	public ComentarioDTO() {
	}

	public ComentarioDTO(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ComentarioDTO texto(String texto) {
		setTexto(texto);
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
		if (!(obj instanceof ComentarioDTO)) {
			return false;
		}
		ComentarioDTO other = (ComentarioDTO) obj;
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
