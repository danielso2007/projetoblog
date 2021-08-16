package br.com.blog.dto;

import java.util.Date;
import java.util.Objects;

public abstract class BaseAuditDTO extends BaseEntityDTO {

	private static final long serialVersionUID = -4002477982000229979L;

	private Date dataCriacao;

	private Date dataAtualizacao;

	protected BaseAuditDTO() {
	}

	protected BaseAuditDTO(Date dataCriacao, Date dataAtualizacao) {
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
		if (!(obj instanceof BaseAuditDTO)) {
			return false;
		}
		BaseAuditDTO other = (BaseAuditDTO) obj;
		return Objects.equals(dataAtualizacao, other.dataAtualizacao) && Objects.equals(dataCriacao, other.dataCriacao);
	}

	@Override
	public String toString() {
		return "BaseAuditDTO [" + (dataCriacao != null ? "dataCriacao=" + dataCriacao + ", " : "")
				+ (dataAtualizacao != null ? "dataAtualizacao=" + dataAtualizacao + ", " : "")
				+ (getId() != null ? "getId()=" + getId() : "") + "]";
	}

}
