package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricantes;

public class FabricanteRepository {

	private Fabricantes[] empresas;
	private Fabricantes sony = new Fabricantes();
	private Fabricantes nintendo = new Fabricantes();
	private Fabricantes microsoft = new Fabricantes();
	private Fabricantes outros = new Fabricantes();
	
	
	public FabricanteRepository() {
		empresas = new Fabricantes[4];
		empresas[0] = sony;
		empresas[1] = microsoft;
		empresas[2] = nintendo;
		empresas[3] = outros;
		
		sony.setNome("Sony");
		microsoft.setNome("Microsoft");
		nintendo.setNome("Nintendo");
		outros.setNome("Outro");	
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
