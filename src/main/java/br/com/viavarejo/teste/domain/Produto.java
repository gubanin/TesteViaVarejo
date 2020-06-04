package br.com.viavarejo.teste.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String nome;
	private BigDecimal valor;

	public Produto() {

	}

	public Produto(Integer codigo, String nome, BigDecimal valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
