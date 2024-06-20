package com.dev.sge.controllers;

import com.dev.sge.models.Mercadoria;
import com.dev.sge.repositories.MercadoriaRepository;
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
public class MercadoriaController {

	@Autowired
	private MercadoriaRepository mercadoriaRepository;


	@GetMapping("mercadorias/cadastrar")
	public ModelAndView cadastrar(Mercadoria mercadoria) {
		ModelAndView mv = new ModelAndView("/administrativo/mercadorias/cadastro");
		mv.addObject("mercadoria", mercadoria);
		return mv;
	}

	@GetMapping("/mercadorias/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/mercadorias/lista");
		mv.addObject("listaMercadorias", mercadoriaRepository.findAll());
		return mv;
	}

	@PostMapping("mercadorias/salvar")
	public ModelAndView salvar(@Valid Mercadoria Mercadoria, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(Mercadoria);
		}
		mercadoriaRepository.save(Mercadoria);
		return cadastrar(new Mercadoria());
	}

	@GetMapping("mercadorias/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Optional<Mercadoria> Mercadoria = mercadoriaRepository.findById(id);
		return cadastrar(Mercadoria.get());
	}

	@GetMapping("mercadorias/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		mercadoriaRepository.deleteById(id);
		return  listar();
	}

}

