package com.condominios.api.model;

public enum Criticidade {

	BAIXA(1, "Baixa"), 
	ALTA(2, "Alta"), 
	MUITO_ALTA(3, "Muito Alta");

	private int codigo;
	private String descricao;

	private Criticidade(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static Criticidade getCriticidade(int id) {
		Criticidade estado = null;
		for (Criticidade item : Criticidade.values()) {
			if (item.getCodigo() == id) {
				estado = item;
				break;
			}
		}
		return estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
