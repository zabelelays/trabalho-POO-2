package com.dev.sge.controllers;

import com.dev.sge.models.Usuario;
import com.dev.sge.repositories.UsuarioRepository;
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
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;


	@GetMapping("usuarios/cadastrar")
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/administrativo/usuarios/cadastro");
		mv.addObject("usuario", usuario);
		return mv;
	}

	@GetMapping("/usuarios/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/usuarios/lista");
		mv.addObject("listaOrcamentos", usuarioRepository.findAll());
		return mv;
	}

	@PostMapping("usuarios/salvar")
	public ModelAndView salvar(@Valid Usuario Usuario, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(Usuario);
		}
		usuarioRepository.save(Usuario);
		return cadastrar(new Usuario());
	}

	@GetMapping("usuarios/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Optional<Usuario> Usuario = usuarioRepository.findById(id);
		return cadastrar(Usuario.get());
	}

	@GetMapping("usuarios/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		usuarioRepository.deleteById(id);
		return  listar();
	}

}

