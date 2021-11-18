package br.senai.sp.jandira.enums;

public enum Consoles {

	PC("PC"),
	PS("PlayStation"),
	MOBILE("Smartphone"),
	XBOX("Xbox"),
	NINTENDO("Nintendo"),
	OUTRO("Outro");
	
	private String descricao;
	private Consoles(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}