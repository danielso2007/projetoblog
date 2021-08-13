package br.com.blog.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "foto", schema = "public", indexes = { @Index(name = "indexFotoAlbumId", columnList = "id_album") })
public class Foto extends BaseEntity {

	private static final long serialVersionUID = 4113993018119463793L;

	/**
	 * Considerar o nome do arquivo.
	 */
	@NotEmpty(message = "O arquivo não pode ser vazio")
	@NotNull(message = "O arquivo não pode ser nulo")
	@Length(max = 200)
	@Column(length = 200, nullable = false)
	private String arquivo;
	/**
	 * O caminho de localização da imagem.<br/>
	 * Pode ser um endereço do firebase ou aws bucket.
	 */
	@NotEmpty(message = "O path não pode ser vazio")
	@NotNull(message = "O path não pode ser nulo")
	@Length(max = 600)
	@Column(length = 600, nullable = false)
	private String path;
	@CreationTimestamp
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	@NotNull(message = "O álbum não pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "id_album", nullable = false)
	private Album album;

	public Foto() {
	}

	public Foto(String arquivo, String path, Date dataCriacao) {
		this.arquivo = arquivo;
		this.path = path;
		this.dataCriacao = dataCriacao;
	}

	public Foto(String arquivo, String path, Date dataCriacao,
			@NotNull(message = "O álbum não pode ser nulo") Album album) {
		this.arquivo = arquivo;
		this.path = path;
		this.dataCriacao = dataCriacao;
		this.album = album;
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Foto arquivo(String arquivo) {
		setArquivo(arquivo);
		return this;
	}

	public Foto path(String path) {
		setPath(path);
		return this;
	}

	public Foto dataCriacao(Date dataCriacao) {
		setDataCriacao(dataCriacao);
		return this;
	}

	public Foto album(Album album) {
		setAlbum(album);
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
		if (!(obj instanceof Foto)) {
			return false;
		}
		Foto other = (Foto) obj;
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
