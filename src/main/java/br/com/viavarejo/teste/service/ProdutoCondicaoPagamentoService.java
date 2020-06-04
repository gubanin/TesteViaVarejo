package br.com.viavarejo.teste.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.teste.domain.Entrada;
import br.com.viavarejo.teste.domain.Parcela;
import br.com.viavarejo.teste.domain.RetornoJuros;
import br.com.viavarejo.teste.domain.RetornoJurosService;
import br.com.viavarejo.teste.service.exception.ErroValidacaoException;

@Service
public class ProdutoCondicaoPagamentoService {

	@Autowired
	public RetornoJurosService service;

	public List<Parcela> simularCompra(Entrada obj) {
		List<RetornoJuros> retornoJuros = service.consultarRetornoJuros(11, 30);
		BigDecimal soma = new BigDecimal(0);
		BigDecimal resultado = new BigDecimal(0);
		for (RetornoJuros retornoJuros2 : retornoJuros) {
			soma = soma.add(retornoJuros2.getValor());
		}
		resultado = soma.divide(new BigDecimal(30), 6, RoundingMode.UP);

		List<Parcela> parcelas = new ArrayList<>();

		if (obj.getProduto().getValor() == null) {
			throw new ErroValidacaoException("Valor do produto nao pode ser nulo");
		}

		if (obj.getCondicaoPagamento().getValorEntrada() == null) {
			throw new ErroValidacaoException("Valor de entrada nao pode ser nulo");
		}

		BigDecimal principal = obj.getProduto().getValor().subtract(obj.getCondicaoPagamento().getValorEntrada());
		Integer meses = obj.getCondicaoPagamento().getQtdeParcelas();
		BigDecimal juros = resultado.multiply(new BigDecimal(100)).setScale(2, RoundingMode.UP);
		BigDecimal valorParcelado = new BigDecimal(0.0);

		if (meses > 6) {
			valorParcelado = principal.multiply(juros).divide(BigDecimal.valueOf(meses), 2, RoundingMode.UP);

		} else {
			valorParcelado = principal.divide(BigDecimal.valueOf(meses), 2, RoundingMode.UP);
			juros = null;
		}

		for (int i = 1; i <= obj.getCondicaoPagamento().getQtdeParcelas(); i++) {
			Parcela p = new Parcela();
			p.setNumeroParcelas(i);
			p.setValor(valorParcelado);
			p.setTaxaJurosAoMes(juros);
			parcelas.add(p);
		}
		return parcelas;
	}
}
