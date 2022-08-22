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

import com.example.demo.dto.MaquinasRegistradoras;
import com.example.demo.service.MaquinasRegistradorasServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinasRegistradorasController {

	@Autowired
	MaquinasRegistradorasServiceImpl maquinasRegistradorasServiceImpl;
	
	@GetMapping("/maquinasRegistradoras")
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras(){
		return maquinasRegistradorasServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinasRegistradoras")
	public MaquinasRegistradoras salvarMaquinasRegistradoras(@RequestBody MaquinasRegistradoras maquinasRegistradoras) {
		
		return maquinasRegistradorasServiceImpl.guardarMaquinasRegistradoras(maquinasRegistradoras);
	}
	
	
	@GetMapping("/maquinasRegistradoras/{id}")
	public MaquinasRegistradoras MaquinasRegistradorasXID(@PathVariable(name="id") int id) {
		
		MaquinasRegistradoras MaquinasRegistradoras_xid= new MaquinasRegistradoras();
		
		MaquinasRegistradoras_xid=maquinasRegistradorasServiceImpl.maquinas_registradorasXID(id);
		
		System.out.println("MaquinasRegistradoras XID: "+MaquinasRegistradoras_xid);
		
		return MaquinasRegistradoras_xid;
	}
	
	@PutMapping("/maquinasRegistradoras/{id}")
	public MaquinasRegistradoras actualizarMaquinasRegistradoras(@PathVariable(name="id")int id,@RequestBody MaquinasRegistradoras MaquinasRegistradoras) {
		
		MaquinasRegistradoras MaquinasRegistradoras_seleccionado= new MaquinasRegistradoras();
		MaquinasRegistradoras MaquinasRegistradoras_actualizado= new MaquinasRegistradoras();
		
		MaquinasRegistradoras_seleccionado= maquinasRegistradorasServiceImpl.maquinas_registradorasXID(id);
		
		MaquinasRegistradoras_seleccionado.setPiso(MaquinasRegistradoras.getPiso());
		MaquinasRegistradoras_seleccionado.setVenta(MaquinasRegistradoras.getVenta());
		
		MaquinasRegistradoras_actualizado = maquinasRegistradorasServiceImpl.actualizarMaquinasRegistradoras(MaquinasRegistradoras_seleccionado);
		
		System.out.println("La maquina actualizada es: "+ MaquinasRegistradoras_actualizado);
		
		return MaquinasRegistradoras_actualizado;
	}
	
	@DeleteMapping("/maquinasRegistradoras/{id}")
	public void eleiminarMaquinasRegistradoras(@PathVariable(name="id")int id) {
		maquinasRegistradorasServiceImpl.eliminarMaquinasRegistradoras(id);
	}
}
