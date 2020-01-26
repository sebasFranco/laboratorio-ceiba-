package com.jsfrancor.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jsfrancor.springboot.app.models.entity.Prestamo;
import com.jsfrancor.springboot.app.service.IPrestamoService;

@Controller
@SessionAttributes("prestamo")
public class PrestamoController {

	@Autowired
	private IPrestamoService prestamoService;
	
	@GetMapping("/listarPrestamos")
	public String listar(Model model) {
		model.addAttribute("titulo", "Consultar Libros Prestados");
		model.addAttribute("prestamos", prestamoService.findAll());
		return "listarPrestamos";
	}
	
	@GetMapping("/crear_prestamo")
	public String crear(Model model) {
		
		Prestamo prestamo = new Prestamo();
		model.addAttribute("titulo", "Crear Prestamo");
		model.addAttribute("prestamo", prestamo);
		return "crear_prestamo";
	}
	
	@RequestMapping(value = "/crear_prestamo", method = RequestMethod.POST)
	public String guardar(@Valid Prestamo prestamo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Prestamo");
			return "crear_prestamo";
		}
		
		prestamoService.save(prestamo);
		return "redirect:listar";
	}
	
}
