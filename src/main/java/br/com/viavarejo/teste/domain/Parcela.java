package br.com.viavarejo.teste.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Parcela implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;
	private BigDecimal valor;
	private BigDecimal taxaJurosAoMes;

	public Parcela() {

	}

	public Parcela(Integer numeroParcelas, BigDecimal valor, BigDecimal taxaJurosAoMes) {
		super();
		this.numeroParcelas = numeroParcelas;
		this.valor = valor;
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxaJurosAoMes() {
		return taxaJurosAoMes;
	}

	public void setTaxaJurosAoMes(BigDecimal taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

}
