package br.com.blog.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseAudit extends BaseEntity {

	private static final long serialVersionUID = -140991262519367385L;

	@CreationTimestamp
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@UpdateTimestamp
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;

	protected BaseAudit() {
	}

	protected BaseAudit(Date dataCriacao, Date dataAtualizacao) {
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return this.dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataAtualizacao, dataCriacao);
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
		if (!(obj instanceof BaseAudit)) {
			return false;
		}
		BaseAudit other = (BaseAudit) obj;
		return Objects.equals(dataAtualizacao, other.dataAtualizacao) && Objects.equals(dataCriacao, other.dataCriacao);
	}

	@Override
	public String toString() {
		return "BaseAudit [dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", getId()=" + getId()
				+ "]";
	}

}
