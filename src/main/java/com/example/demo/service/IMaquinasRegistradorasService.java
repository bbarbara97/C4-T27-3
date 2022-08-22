package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajeros;
import com.example.demo.dto.MaquinasRegistradoras;

public interface IMaquinasRegistradorasService {

	//Metodos del CRUD
			public List<MaquinasRegistradoras> listarMaquinasRegistradoras(); //Listar All 
			
			public MaquinasRegistradoras guardarMaquinasRegistradoras(MaquinasRegistradoras maquinas_registradoras);	//Guarda un Estudiante CREATE
			
			public MaquinasRegistradoras maquinas_registradorasXID(int id); //Leer datos de un Estudiante READ
			
			public MaquinasRegistradoras actualizarMaquinasRegistradoras(MaquinasRegistradoras maquinas_registradoras); //Actualiza datos del estudiante UPDATE
			
			public void eliminarMaquinasRegistradoras(int id);// Elimina el estudiante DELETE
}
