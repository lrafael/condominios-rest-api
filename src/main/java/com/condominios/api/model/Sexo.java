package com.condominios.api.model;

public enum Sexo {

	MASCULINO(0, "Masculino"), 
	FEMININO(1, "Feminino");

	private int codigo;
	private String descricao;

	private Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static Sexo getSexo(int id) {
		Sexo estado = null;
		for (Sexo item : Sexo.values()) {
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
