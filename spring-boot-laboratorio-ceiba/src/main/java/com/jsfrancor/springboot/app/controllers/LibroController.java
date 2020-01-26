package com.jsfrancor.springboot.app.controllers;

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
import com.jsfrancor.springboot.app.service.ILibroService;

@Controller
@SessionAttributes("libro")
public class LibroController {
	
	@Autowired
	private ILibroService libroService;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Consultar Libros");
		model.addAttribute("libros", libroService.findAll());
		return "listar";
	}
	
	@GetMapping("/crear_libro")
	public String crear(Model model) {
		
		Libro libro = new Libro();
		model.addAttribute("titulo", "Crear Libro");
		model.addAttribute("libro", libro);
		return "crear_libro";
	}
	
	@RequestMapping(value = "/crear_libro", method = RequestMethod.POST)
	public String guardar(@Valid Libro libro, BindingResult result, Model model) {
		
		boolean existe=false;
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Libro");
			return "crear_libro";
		}
		
		List<Libro> libros = libroService.findAll();
		
		for(Libro libro1 : libros) {
			if(libro1.getIsbn().equals(libro.getIsbn())) {
				libro1.setCantidad(libro1.getCantidad()+1);
				libroService.save(libro1);
				existe = true;
			}else {
				libro.setCantidad(1);
			}
		}
		
		if(existe) {
			return "redirect:listar";
		}else {
			libroService.save(libro);
			return "redirect:listar";
		}
		
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) {
		
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
		
		model.addAttribute("titulo", "Crear Libro");
		libro.setCantidad(libro.getCantidad()-1);
		libroService.save(libro);
		return "redirect:/listar";
	}	
}
