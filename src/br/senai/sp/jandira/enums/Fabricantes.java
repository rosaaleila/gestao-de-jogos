package br.senai.sp.jandira.enums;

public enum Fabricantes {
	SONY("Sony"),
	MICROSOFT("Microsoft"),
	NINTENDO("Nintendo"),
	EA("Eletronic Arts"),
	EPIC("EPIC Games"),
	OUTRO("Outro");
	
	private String descricao;
	private Fabricantes(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
	
}
