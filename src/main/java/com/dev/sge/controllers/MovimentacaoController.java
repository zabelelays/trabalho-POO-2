package com.dev.sge.controllers;

import com.dev.sge.models.Mercadoria;
import com.dev.sge.models.Movimentacao;
import com.dev.sge.repositories.MercadoriaRepository;
import com.dev.sge.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	MercadoriaRepository mercadoriaRepository;


	@GetMapping("movimentacoes/cadastrar")
	public ModelAndView cadastrar(Movimentacao movimentacao) {
		ModelAndView mv = new ModelAndView("/administrativo/movimentacoes/cadastro");
		mv.addObject("movimentacao", movimentacao);
		mv.addObject("listaMercadorias", mercadoriaRepository.findAll());
		return mv;
	}

	@GetMapping("/movimentacoes/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/movimentacoes/lista");
		mv.addObject("listaMovimentacoes", movimentacaoRepository.findAll());
		return mv;
	}

	@PostMapping("movimentacoes/salvar")
	public ModelAndView salvar(@Valid Movimentacao movimentacao, BindingResult result) {
		Mercadoria mercadoria = mercadoriaRepository.findById(movimentacao.getMercadoria().getId())
				.orElseThrow(() -> new IllegalArgumentException("Mercadoria inválida:" + movimentacao.getMercadoria().getId()));
		movimentacao.setMercadoria(mercadoria);
		if(result.hasErrors()) {
			System.out.println("Erro ao salvar");
			return cadastrar(movimentacao);
		}
		movimentacaoRepository.save(movimentacao);
		return cadastrar(new Movimentacao());
	}

	@GetMapping("movimentacoes/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
		return cadastrar(movimentacao.get());
	}

	@GetMapping("movimentacoes/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		movimentacaoRepository.deleteById(id);
		return  listar();
	}

}

