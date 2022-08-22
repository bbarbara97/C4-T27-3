package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Productos;

public interface IProductosService {

	//Metodos del CRUD
			public List<Productos> listarProductos(); //Listar All 
			
			public Productos guardarProductos(Productos productos);	//Guarda un Estudiante CREATE
			
			public Productos productosXID(int id); //Leer datos de un Estudiante READ
			
			public Productos actualizarProductos(Productos productos); //Actualiza datos del estudiante UPDATE
			
			public void eliminarProductos(int id);// Elimina el estudiante DELETE
}
