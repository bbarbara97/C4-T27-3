package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cajeros")//en caso que la tabla sea diferente
public class Cajeros {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int codigo;
		@Column(name = "nom_apels")//no hace falta si se llama igual
		private String nomApels;
		
		@OneToMany
	    @JoinColumn(name="codigo")
	    private List<Venta> venta;

		//Constructores
		
		public Cajeros() {

		}

		public Cajeros(int codigo, String nomApels, List<Venta> venta) {
			this.codigo = codigo;
			this.nomApels = nomApels;
			this.venta = venta;
		}

		//Getters y Setters
		
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNomApels() {
			return nomApels;
		}

		public void setNomApels(String nomApels) {
			this.nomApels = nomApels;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
		public List<Venta> getVenta() {
			return venta;
		}

		public void setVenta(List<Venta> venta) {
			this.venta = venta;
		}
		
		//Metodo toString
	
		@Override
		public String toString() {
			return "Cajeros [codigo=" + codigo + ", nomApels=" + nomApels + ", venta=" + venta + "]";
		}
}
