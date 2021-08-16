package br.com.blog.dto;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class FotoDTO extends BaseEntityDTO {

	private static final long serialVersionUID = 4152844474872194870L;

	@NotEmpty(message = "O arquivo não pode ser vazio")
	@NotNull(message = "O arquivo não pode ser nulo")
	@Length(max = 200)
	private String arquivo;

	@NotEmpty(message = "O path não pode ser vazio")
	@NotNull(message = "O path não pode ser nulo")
	@Length(max = 600)
	private String path;

	private Date dataCriacao;

	public FotoDTO() {
	}

	public FotoDTO(String arquivo, String path, Date dataCriacao) {
		this.arquivo = arquivo;
		this.path = path;
		this.dataCriacao = dataCriacao;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public FotoDTO arquivo(String arquivo) {
		setArquivo(arquivo);
		return this;
	}

	public FotoDTO path(String path) {
		setPath(path);
		return this;
	}

	public FotoDTO dataCriacao(Date dataCriacao) {
		setDataCriacao(dataCriacao);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(arquivo, dataCriacao, path);
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
		if (!(obj instanceof FotoDTO)) {
			return false;
		}
		FotoDTO other = (FotoDTO) obj;
		return Objects.equals(arquivo, other.arquivo) && Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(path, other.path);
	}

	@Override
	public String toString() {
		return "Foto [" + (arquivo != null ? "arquivo=" + arquivo + ", " : "")
				+ (path != null ? "path=" + path + ", " : "")
				+ (dataCriacao != null ? "dataCriacao=" + dataCriacao + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
