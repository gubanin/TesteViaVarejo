package br.com.viavarejo.teste.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.viavarejo.teste.domain.CondicaoPagamento;
import br.com.viavarejo.teste.domain.Entrada;
import br.com.viavarejo.teste.domain.Parcela;
import br.com.viavarejo.teste.domain.Produto;

public class TesteServiço {

	@Test
	public void deveParcelarPagamento() {

		Produto produto = new Produto(123, "produto", new BigDecimal("999.00"));
		CondicaoPagamento cp = new CondicaoPagamento(new BigDecimal("0"), 3);

		ProdutoCondicaoPagamentoService servico = new ProdutoCondicaoPagamentoService();
		List<Parcela> lista = servico.simularCompra(new Entrada(produto, cp));

		BigDecimal valorEsperado = new BigDecimal("333.00");
		assertEquals(3, lista.size());
		assertEquals(valorEsperado, lista.get(0).getValor());
		assertEquals(valorEsperado, lista.get(1).getValor());
		assertEquals(valorEsperado, lista.get(2).getValor());
	}

	@Test
	public void deveParcelarPagamentoComValorQuebrado() {
		Produto produto = new Produto(123, "produto", new BigDecimal("1000.00"));
		CondicaoPagamento cp = new CondicaoPagamento(new BigDecimal("0"), 3);

		ProdutoCondicaoPagamentoService servico = new ProdutoCondicaoPagamentoService();
		List<Parcela> lista = servico.simularCompra(new Entrada(produto, cp));

		BigDecimal valorEsperado = new BigDecimal("333.33");
		assertEquals(3, lista.size());
		assertEquals(valorEsperado, lista.get(0).getValor());
		assertEquals(valorEsperado, lista.get(1).getValor());
		assertEquals(valorEsperado, lista.get(2).getValor());
	}

	@Test
	public void deveParcelarPagamentoComJuros() {
		Produto p = new Produto(1, "nome", new BigDecimal("1000.00"));
		CondicaoPagamento cp = new CondicaoPagamento(new BigDecimal("100.00"), 8);

		ProdutoCondicaoPagamentoService service = new ProdutoCondicaoPagamentoService();
		List<Parcela> lista = service.simularCompra(new Entrada(p, cp));

		BigDecimal valorEsperado = new BigDecimal("129.37");
		assertEquals(8, lista.size());
		assertEquals(valorEsperado, lista.get(0).getValor());
		assertEquals(valorEsperado, lista.get(1).getValor());
		assertEquals(valorEsperado, lista.get(2).getValor());
		assertEquals(valorEsperado, lista.get(3).getValor());
		assertEquals(valorEsperado, lista.get(4).getValor());
		assertEquals(valorEsperado, lista.get(5).getValor());
		assertEquals(valorEsperado, lista.get(6).getValor());
		assertEquals(valorEsperado, lista.get(7).getValor());
	}
}
