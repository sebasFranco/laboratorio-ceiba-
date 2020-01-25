insert into libros (id, isbn, nombre, cantidad) values (1, '123asd', 'Libro 1', 1);
insert into libros (id, isbn, nombre, cantidad) values (2, '098dsa', 'Libro 2', 1);
insert into libros (id, isbn, nombre, cantidad) values (3, '056bnm', 'Libro 3', 0);

insert into prestamos (id, nombrePersona, isbn, fecha_prestamo, fecha_entrega_maxima) values (1, 'Juan', '056bnm', '2020-01-25', null);