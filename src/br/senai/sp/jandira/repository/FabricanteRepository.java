package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricantes;

public class FabricanteRepository {

	private Fabricantes[] empresas;

	public FabricanteRepository() {
		empresas = new Fabricantes[6];
	}
	
	public FabricanteRepository(int quantidade) {
		empresas = new Fabricantes[quantidade];
	}

	public void gravar(Fabricantes fabricanteCriado, int posicao) {
		empresas[posicao] = fabricanteCriado;
	}
	
	public Fabricantes listarFabricante(int posicao) {
		return empresas[posicao];
	}
	
	public Fabricantes[] listarTodos() {
		return empresas;
	}
	
	public int getTamanho() {
		return empresas.length;
	}
	
	public void deletarFabricante(int indice) {
		empresas[indice] = null;
	}
	
}
