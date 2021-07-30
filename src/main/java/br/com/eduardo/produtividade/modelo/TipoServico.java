package br.com.eduardo.produtividade.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Double meta;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	public TipoServico() {
	}
	
	public TipoServico(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getMeta() {
		return meta;
	}

	public void setMeta(Double meta) {
		this.meta = meta;
	}
	
	

}
