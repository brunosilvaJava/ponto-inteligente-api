package com.estudo.pontointeligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.estudo.pontointeligente.api.enums.PerfilEnum;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -5730742253818646343L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome", nullable = true)
	private String nome;
	
	@Column(name="email", nullable = true)
	private String email;
	
	@Column(name="senha", nullable = true)
	private String senha;
	
	@Column(name="cpf", nullable = true)
	private String cpf;
	
	@Column(name="valor_hora", nullable = true)
	private BigDecimal valorHora;
	
	@Column(name="qtd_horas_trabalho_dia", nullable = true)
	private Float qtdHorasTrabalhoDia;
	
	@Column(name="qtd_horas_almoco")
	private Float qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(name="perfil", nullable = true)
	private PerfilEnum perfil;
	
	@Column(name="data_criacao", nullable=true)
	private Date dataCriacao;
	
	@Column(name="data_atualizadao", nullable=true)
	private Date dataAtualizacao;
	
	@ManyToOne
	private Empresa empresa;
	
	@OneToMany(mappedBy="funcionario", cascade=CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	public Funcionario() {		
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
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}
	
	@Transient
	public Optional<Float> getHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	
	@Transient
	public Optional<Float> getHorasAlmocoOpt() {
		return Optional.ofNullable(qtdHorasAlmoco);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}

	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
