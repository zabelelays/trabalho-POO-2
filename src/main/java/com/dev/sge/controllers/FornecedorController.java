package com.dev.sge.controllers;

import com.dev.sge.models.Fornecedor;
import com.dev.sge.repositories.FornecedorRepository;
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
	private FornecedorRepository fornecedorRepository;


	@GetMapping("fornecedores/cadastrar")
	public ModelAndView cadastrar(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("/administrativo/fornecedores/cadastro");
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}

	@GetMapping("/fornecedores/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/fornecedores/lista");
		mv.addObject("listaFornecedors", fornecedorRepository.findAll());
		return mv;
	}

	@PostMapping("fornecedores/salvar")
	public ModelAndView salvar(@Valid Fornecedor fornecedor, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Erro ao salvar");
			return cadastrar(fornecedor);
		}
		fornecedorRepository.save(fornecedor);
		return cadastrar(new Fornecedor());
	}

	@GetMapping("fornecedores/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return cadastrar(fornecedor.get());
	}

	@GetMapping("fornecededores/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		fornecedorRepository.deleteById(id);
		return  listar();
	}

}

