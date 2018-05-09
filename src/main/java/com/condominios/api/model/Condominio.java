package com.condominios.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "condominio")
public class Condominio implements Serializable {
	
	private static final long serialVersionUID = -1807249279196080220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@Column(name = "numero_blocos")
	private Long numeroBlocos;
	
	@Column(name = "numero_apartamentos_por_bloco")
	private Long numeroApartamentosPorBloco;
	
	@JsonIgnore
	@OneToMany(targetEntity = Apartamento.class, mappedBy = "condominio")
    private List<Apartamento> apartamentos = new ArrayList<Apartamento>();
	
	@JsonIgnore
	@OneToMany(targetEntity = Chamado.class, mappedBy = "condominio")
    private List<Chamado> chamados = new ArrayList<Chamado>();

	
	
	
	
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getNumeroBlocos() {
		return numeroBlocos;
	}

	public void setNumeroBlocos(Long numeroBlocos) {
		this.numeroBlocos = numeroBlocos;
	}

	public Long getNumeroApartamentosPorBloco() {
		return numeroApartamentosPorBloco;
	}

	public void setNumeroApartamentosPorBloco(Long numeroApartamentosPorBloco) {
		this.numeroApartamentosPorBloco = numeroApartamentosPorBloco;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apartamentos == null) ? 0 : apartamentos.hashCode());
		result = prime * result + ((chamados == null) ? 0 : chamados.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroApartamentosPorBloco == null) ? 0 : numeroApartamentosPorBloco.hashCode());
		result = prime * result + ((numeroBlocos == null) ? 0 : numeroBlocos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condominio other = (Condominio) obj;
		if (apartamentos == null) {
			if (other.apartamentos != null)
				return false;
		} else if (!apartamentos.equals(other.apartamentos))
			return false;
		if (chamados == null) {
			if (other.chamados != null)
				return false;
		} else if (!chamados.equals(other.chamados))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroApartamentosPorBloco == null) {
			if (other.numeroApartamentosPorBloco != null)
				return false;
		} else if (!numeroApartamentosPorBloco.equals(other.numeroApartamentosPorBloco))
			return false;
		if (numeroBlocos == null) {
			if (other.numeroBlocos != null)
				return false;
		} else if (!numeroBlocos.equals(other.numeroBlocos))
			return false;
		return true;
	}

	
}
