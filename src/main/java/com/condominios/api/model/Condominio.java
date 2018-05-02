package com.condominios.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "condominio")
public class Condominio implements Serializable {
	
	private static final long serialVersionUID = -1807249279196080220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Endereco endereco;
	
	@Column(name = "numeroblocos")
	private Long numeroBlocos;
	
	@Column(name = "numeroapartamentoporbloco")
	private Long numeroApartamentosPorBloco;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
