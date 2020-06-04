package br.com.viavarejo.teste.domain;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "retornoJuros", url = "https://api.bcb.gov.br")
public interface RetornoJurosService {
	// http://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados/ultimos/10?formato=json

	@RequestMapping(value = "/dados/serie/bcdata.sgs.{codigo_serie}/dados/ultimos/{dias}?formato=json", method = RequestMethod.GET)

	public List<RetornoJuros> consultarRetornoJuros(@PathVariable("codigo_serie") Integer codigo_serie,
			@PathVariable("dias") Integer dias);
}
