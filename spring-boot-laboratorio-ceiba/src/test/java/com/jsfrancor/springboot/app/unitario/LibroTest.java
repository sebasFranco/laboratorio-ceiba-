package com.jsfrancor.springboot.app.unitario;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.jsfrancor.springboot.app.models.entity.Libro;
import com.jsfrancor.springboot.app.testdatabuilder.LibroTestDataBuilder;

public class LibroTest {
	
	private static final Long ID= 2L;
	private static final String ISBN = "12321";
	private static final String NOMBRE = "Caperucita";
	private static final int CANTIDAD = 1;
	
	@Test
	public void crearLibroTest() {
		
		// arrange
		LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().
				conId(ID).
				conIsbn(ISBN).
				conNombre(NOMBRE).
				conCantidad(CANTIDAD);

		// act
		Libro libro = libroTestDataBuilder.build();

		// assert
		assertEquals(ID, libro.getId());
		assertEquals(NOMBRE, libro.getNombre());
		assertEquals(ISBN, libro.getIsbn());
		assertEquals(CANTIDAD, libro.getCantidad(),0);
	}
	
}