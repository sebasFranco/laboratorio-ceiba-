package com.jsfrancor.springboot.app.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsfrancor.springboot.app.models.entity.Libro;
import com.jsfrancor.springboot.app.models.entity.Prestamo;
import com.jsfrancor.springboot.app.service.ILibroService;
import com.jsfrancor.springboot.app.service.IPrestamoService;

@Controller
@SessionAttributes("prestamo")
public class PrestamoController {

	@Autowired
	private IPrestamoService prestamoService;
	
	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/listarPrestamos")
	public String listar(Model model) {
		model.addAttribute("titulo", "Consultar Libros Prestados");
		model.addAttribute("prestamos", prestamoService.findAll());
		return "listarPrestamos";
	}
	
	@RequestMapping(value = "/crear_prestamo/{id}")
	public String crear(@PathVariable(value = "id") Long id,  Model model, RedirectAttributes flash) {
		
		Libro libro = null;
		
		if(id>0) {
			libro = libroService.findOne(id);
			if(libro == null) {
				flash.addFlashAttribute("error", "El ID del libro no existe en la base de datos");
				return "redirect:/listar";
			}
		}else {
			flash.addFlashAttribute("error", "El ID del libro no puede ser 0");
			return "redirect:/listar";
		}
		
		Prestamo prestamo = new Prestamo();
		prestamo.setIsbnLibro(libro.getIsbn());
		prestamo.setFechaPrestamo(new Date());
		if (prestamo.validarPalindromoStream()) {
			flash.addFlashAttribute("error", "Los libros palíndromos solo se pueden utilizar en la biblioteca");
			return "redirect:/listar";
		} else {
			prestamo.generarPrestamo();
			model.addAttribute("titulo", "Crear Prestamo");
			model.addAttribute("prestamo", prestamo);
			return "crear_prestamo";
		}
		
	}
	
	@RequestMapping(value = "/crear_prestamo", method = RequestMethod.POST)
	public String guardar(@Valid Prestamo prestamo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Prestamo");
			return "crear_prestamo";
		}
		
		List<Libro> libros = libroService.findAll();
		
		for(Libro libro1 : libros) {
			if(libro1.getIsbn().equals(prestamo.getIsbnLibro())) {
				libro1.setCantidad(libro1.getCantidad()-1);
				libroService.save(libro1);
			}
		}
		
		prestamoService.save(prestamo);
		return "redirect:listar";
	}
	
}
