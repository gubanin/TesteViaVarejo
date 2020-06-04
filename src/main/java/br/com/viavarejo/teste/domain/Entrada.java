package br.com.viavarejo.teste.domain;

import java.io.Serializable;

public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	private Produto produto;
	private CondicaoPagamento condicaoPagamento;

	public Entrada() {

	}

	public Entrada(Produto produto, CondicaoPagamento condicaoPagamento) {
		super();
		this.produto = produto;
		this.condicaoPagamento = condicaoPagamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

}
