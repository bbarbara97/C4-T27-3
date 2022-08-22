package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cajeros;
import com.example.demo.service.CajerosServiceImpl;

@RestController
@RequestMapping("/api")
public class CajerosController {

	@Autowired
	CajerosServiceImpl cajerosServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return cajerosServiceImpl.listarCajeros();
	}
	
	
	@PostMapping("/cajeros")
	public Cajeros salvarCajeros(@RequestBody Cajeros cajeros) {
		
		return cajerosServiceImpl.guardarCajeros(cajeros);
	}
	
	
	@GetMapping("/cajeros/{id}")
	public Cajeros CajerosXID(@PathVariable(name="id") int id) {
		
		Cajeros Cajeros_xid= new Cajeros();
		
		Cajeros_xid=cajerosServiceImpl.cajerosXID(id);
		
		System.out.println("Cajeros XID: "+Cajeros_xid);
		
		return Cajeros_xid;
	}
	
	@PutMapping("/cajeros/{id}")
	public Cajeros actualizarCajeros(@PathVariable(name="id")int id,@RequestBody Cajeros Cajeros) {
		
		Cajeros Cajeros_seleccionado= new Cajeros();
		Cajeros Cajeros_actualizado= new Cajeros();
		
		Cajeros_seleccionado= cajerosServiceImpl.cajerosXID(id);
		
		Cajeros_seleccionado.setNomApels(Cajeros.getNomApels());
		Cajeros_seleccionado.setVenta(Cajeros.getVenta());
		
		Cajeros_actualizado = cajerosServiceImpl.actualizarCajeros(Cajeros_seleccionado);
		
		System.out.println("El cajero actualizado es: "+ Cajeros_actualizado);
		
		return Cajeros_actualizado;
	}
	
	@DeleteMapping("/cajeros/{id}")
	public void eleiminarCajeros(@PathVariable(name="id")int id) {
		cajerosServiceImpl.eliminarCajeros(id);
	}
}
