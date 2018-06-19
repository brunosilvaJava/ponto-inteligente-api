package com.estudo.pontointeligente.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.estudo.pontointeligente.api.enums.TipoEnum;

@Entity
@Table(name="lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = -5730742253818646343L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data", nullable=true)
	private Date data;
	
	@Column(name="descricao", nullable=true)
	private String descricao;
	
	@Column(name="localizacao", nullable=true)
	private String localizacao;
	
	@Column(name="data_criacao", nullable=true)
	private Date dataCriacao;
	
	@Column(name="data_atualizadao", nullable=true)
	private Date dataAtualizacao;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable=false)
	private TipoEnum tipo;
	
	@ManyToOne
	private Funcionario funcionario;
	
	public Lancamento() {
	}
	
	@PrePersist
	private void prePersist() {
		dataCriacao = new Date();
		dataAtualizacao = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		dataAtualizacao = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
