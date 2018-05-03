package com.condominios.api.model;

public enum Estado {

	SP(1, "São Paulo", "SP");

	private int codigo;
	private String descricao;
	private String sigla;

	private Estado(int codigo, String descricao, String sigla) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public static Estado getEstado(String sigla) {
		Estado estado = null;
		for (Estado item : Estado.values()) {
			if (item.getSigla() == sigla) {
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

	public String getSigla() {
		return sigla;
	}

}
