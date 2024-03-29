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
@Table(name = "imagem", schema = "public", indexes = { @Index(name = "indexImagemPostId", columnList = "id_post") })
public class Imagem extends BaseEntity {

	private static final long serialVersionUID = 4113993018119463793L;

	@NotEmpty(message = "O título não pode ser vazio")
	@Length(max = 200)
	@Column(length = 200)
	private String titulo;
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
	@NotNull(message = "O post não pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "id_post", nullable = false)
	private Post post;

	public Imagem() {
	}

	public Imagem(String titulo, String arquivo, String path, Date dataCriacao) {
		this.titulo = titulo;
		this.arquivo = arquivo;
		this.path = path;
		this.dataCriacao = dataCriacao;
	}

	public Imagem(String titulo, String arquivo, String path, Date dataCriacao, Post post) {
		this.titulo = titulo;
		this.arquivo = arquivo;
		this.path = path;
		this.dataCriacao = dataCriacao;
		this.post = post;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Imagem titulo(String titulo) {
		setTitulo(titulo);
		return this;
	}

	public Imagem arquivo(String arquivo) {
		setArquivo(arquivo);
		return this;
	}

	public Imagem path(String path) {
		setPath(path);
		return this;
	}

	public Imagem dataCriacao(Date dataCriacao) {
		setDataCriacao(dataCriacao);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(arquivo, dataCriacao, path, titulo);
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
		if (!(obj instanceof Imagem)) {
			return false;
		}
		Imagem other = (Imagem) obj;
		return Objects.equals(arquivo, other.arquivo) && Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(path, other.path) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Imagem [" + (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (arquivo != null ? "arquivo=" + arquivo + ", " : "") + (path != null ? "path=" + path + ", " : "")
				+ (dataCriacao != null ? "dataCriacao=" + dataCriacao + ", " : "")
				+ (post != null ? "post=" + post + ", " : "") + (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
