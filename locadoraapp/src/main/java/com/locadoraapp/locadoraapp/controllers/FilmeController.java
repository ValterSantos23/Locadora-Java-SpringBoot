package com.locadoraapp.locadoraapp.controllers;

import org.aspectj.weaver.bcel.AtAjAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.locadoraapp.locadoraapp.models.Filme;
import com.locadoraapp.locadoraapp.repository.FilmeRepository;

@Controller
public class FilmeController {
	
	@Autowired
	private FilmeRepository er;
	
	@RequestMapping(value="/CadastrarFilme", method = RequestMethod.GET)
	public String form() {
		return "filme/formFilme";
	}
	
	@RequestMapping(value="/CadastrarFilme", method = RequestMethod.POST)
	public String form(Filme filme) {
		
		er.save(filme);
		
		return "redirect:/CadastrarFilme";
	}
	
	@RequestMapping("/filmes")
	public ModelAndView listaFilmes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Filme> filmes = er.findAll();
		mv.addObject("filmes", filmes);
		return mv;
	}
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesFilme(@PathVariable("codigo") long codigo) {
		Filme filme = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("filme/detalhesFilme");
		mv.addObject("filme", filme);
		return mv;
	}
}
