package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Jogo;

public class JogoRepository {
	private Jogo[] colecao;
	
	public JogoRepository() {
		colecao = new Jogo[25];
	}
	
	public JogoRepository(int quantidadeDeJogos) {
		colecao = new Jogo[quantidadeDeJogos];
	}
	
	public void cadastrar(Jogo jogo, int posicao) {
		colecao[posicao] = jogo;
	}
	
	public Jogo listarJogo(int posicao) {
		return colecao[posicao];
	}
	
	public Jogo[] listarTodos() {
		return colecao;
	}
	
	public int getTamanho() {
		return colecao.length;
	}
	
	public void deletarJogo(int indice) {
		colecao[indice] = null;
	}
	

}
