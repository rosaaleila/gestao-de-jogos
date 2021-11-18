package br.senai.sp.jandira.model;

import br.senai.sp.jandira.enums.Consoles;

public class Jogo {
	private String titulo;
	private String valor;
	private Fabricantes fabricante;
	private String estado;
	private Consoles console;
	private String observacoes;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Fabricantes getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricantes fabricante) {
		this.fabricante = fabricante;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setConsole(Consoles console) {
		this.console = console;
	}
	
	public Consoles getConsole() {
		return console;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
}
