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
import com.example.demo.dto.Productos;
import com.example.demo.service.CajerosServiceImpl;
import com.example.demo.service.ProductosServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductosController {

	@Autowired
	ProductosServiceImpl productosServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return productosServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Productos salvarProductos(@RequestBody Productos productos) {
		
		return productosServiceImpl.guardarProductos(productos);
	}
	
	
	@GetMapping("/productos/{id}")
	public Productos ProductosXID(@PathVariable(name="id") int id) {
		
		Productos Productos_xid= new Productos();
		
		Productos_xid=productosServiceImpl.productosXID(id);
		
		System.out.println("Productos XID: "+Productos_xid);
		
		return Productos_xid;
	}
	
	@PutMapping("/productos/{id}")
	public Productos actualizarProductos(@PathVariable(name="id")int id,@RequestBody Productos Productos) {
		
		Productos Productos_seleccionado= new Productos();
		Productos Productos_actualizado= new Productos();
		
		Productos_seleccionado= productosServiceImpl.productosXID(id);
		
		Productos_seleccionado.setNombre(Productos.getNombre());
		Productos_seleccionado.setPrecio(Productos.getPrecio());
		Productos_seleccionado.setVenta(Productos.getVenta());
		
		Productos_actualizado = productosServiceImpl.actualizarProductos(Productos_seleccionado);
		
		System.out.println("El producto actualizado es: "+ Productos_actualizado);
		
		return Productos_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public void eleiminarProductos(@PathVariable(name="id")int id) {
		productosServiceImpl.eliminarProductos(id);
	}
	
}
