package com.dev.sge.controllers;

import com.dev.sge.models.Orcamento;
import com.dev.sge.repositories.OrcamentoRepository;
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
public class OrcamentoController {

	@Autowired
	private OrcamentoRepository orcamentoRepository;


	@GetMapping("orcamentos/cadastrar")
	public ModelAndView cadastrar(Orcamento orcamento) {
		ModelAndView mv = new ModelAndView("/administrativo/orcamentos/cadastro");
		mv.addObject("orcamento", orcamento);
		return mv;
	}

	@GetMapping("/orcamentos/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/orcamentos/lista");
		mv.addObject("listaOrcamentos", orcamentoRepository.findAll());
		return mv;
	}

	@PostMapping("orcamentos/salvar")
	public ModelAndView salvar(@Valid Orcamento orcamento, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Erro ao salvar");
			return cadastrar(orcamento);
		}
		orcamentoRepository.save(orcamento);
		return cadastrar(new Orcamento());
	}

	@GetMapping("orcamentos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
		return cadastrar(orcamento.get());
	}

	@GetMapping("orcamentos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		orcamentoRepository.deleteById(id);
		return  listar();
	}

}

