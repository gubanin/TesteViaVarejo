package br.com.viavarejo.teste.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CondicaoPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal valorEntrada;
	private Integer qtdeParcelas;

	public CondicaoPagamento() {

	}

	public CondicaoPagamento(BigDecimal valorEntrada, Integer qtdeParcelas) {
		super();
		this.valorEntrada = valorEntrada;
		this.qtdeParcelas = qtdeParcelas;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Integer getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(Integer qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

}
