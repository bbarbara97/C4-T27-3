package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajeros;

public interface ICajerosService {

	//Metodos del CRUD
			public List<Cajeros> listarCajeros(); //Listar All 
			
			public Cajeros guardarCajeros(Cajeros cajeros);	//Guarda un Estudiante CREATE
			
			public Cajeros cajerosXID(int id); //Leer datos de un Estudiante READ
			
			public Cajeros actualizarCajeros(Cajeros cajeros); //Actualiza datos del estudiante UPDATE
			
			public void eliminarCajeros(int id);// Elimina el estudiante DELETE
}
