package com.dev.sge.controllers;

import com.dev.sge.models.Fornecedor;
import com.dev.sge.repositories.ForncedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import javax.validation.Valid;

@Controller
public class FornecedorController {

	@Autowired
	private ForncedorRepository fornecedorRepository;


	@GetMapping("funcionarios/cadastrar")
	public ModelAndView cadastrar(Fornecedor funcionario) {
		ModelAndView mv = new ModelAndView("/administrativo/funcionarios/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@GetMapping("/funcionarios/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
		mv.addObject("listaFornecedors", fornecedorRepository.findAll());
		return mv;
	}

	@PostMapping("funcionarios/salvar")
	public ModelAndView salvar(@Valid Fornecedor funcionario, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(funcionario);
		}
		fornecedorRepository.save(funcionario);
		return cadastrar(new Fornecedor());
	}

	@GetMapping("funcionarios/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Optional<Fornecedor> funcionario = fornecedorRepository.findById(id);
		return cadastrar(funcionario.get());
	}

	@GetMapping("funcionarios/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		fornecedorRepository.deleteById(id);
		return  listar();
	}

}

