insert into libros (id, isbn, nombre, cantidad) values (1, '123asd', 'Libro 1', 1);
insert into libros (id, isbn, nombre, cantidad) values (2, '098dsa', 'Libro 2', 1);
insert into libros (id, isbn, nombre, cantidad) values (3, '456fhg', 'Libro 3', 0);

insert into prestamos (id, nombre_persona, isbn_libro, fecha_prestamo,fecha_entrega_maxima) values (1, 'Juan', '456fhg', '2020-01-25', null);