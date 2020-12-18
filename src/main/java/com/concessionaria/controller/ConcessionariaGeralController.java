package com.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.concessionaria.model.Carro;
import com.concessionaria.repository.CarroRepository;

@Controller
public class ConcessionariaGeralController {

	@Autowired
	private CarroRepository carroRepository;
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public String cadastro() {
		return "cadastro/cadastro";
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
	public ModelAndView cadastro(Carro carro) {
		carroRepository.save(carro);
		ModelAndView model = new ModelAndView("cadastro/exibir");
		Iterable<Carro> carro1 = carroRepository.findAll();
		model.addObject("carro", carro1);
		return model;
	}
	
	@RequestMapping("/exibir")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("cadastro/exibir");
		Iterable<Carro> carro = carroRepository.findAll();
		model.addObject("carro", carro);
		return model;
	}
	
	@RequestMapping("/deletar")
	public ModelAndView deletar(Integer cod) {
		Carro carro = carroRepository.findByCod(cod);
		carroRepository.delete(carro);
		ModelAndView model = new ModelAndView("cadastro/exibir");
		Iterable<Carro> carro1 = carroRepository.findAll();
		model.addObject("carro", carro1);
		return model;
	}
	
	@RequestMapping("editar/{cod}")
	public ModelAndView editar(@PathVariable("cod") Integer cod) {
		ModelAndView model = new ModelAndView("cadastro/editar");
		Carro carro = carroRepository.findByCod(cod);
		model.addObject("carro", carro);
		return model;
	}
	
}
