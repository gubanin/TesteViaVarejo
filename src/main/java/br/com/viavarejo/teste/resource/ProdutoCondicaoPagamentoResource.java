package br.com.viavarejo.teste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.teste.domain.Entrada;
import br.com.viavarejo.teste.domain.Parcela;
import br.com.viavarejo.teste.service.ProdutoCondicaoPagamentoService;

@RestController
@RequestMapping(value = "/simulacao")
public class ProdutoCondicaoPagamentoResource {

	@Autowired
	private ProdutoCondicaoPagamentoService service;

	@PostMapping
	public ResponseEntity<List<Parcela>> simularCompra(@RequestBody Entrada obj) {
		List<Parcela> parcelas = service.simularCompra(obj);
		return ResponseEntity.ok().body(parcelas);
	}
}
