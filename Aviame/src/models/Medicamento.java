package models;
// Generated 07-feb-2017 12:59:42 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Medicamento generated by hbm2java
 */
public class Medicamento implements java.io.Serializable {

	private Integer idMedicamento;
	private String nombre;
	private Date fechaCaducidad;
	private Set tratamientos = new HashSet(0);

	public Medicamento() {
	}

	public Medicamento(String nombre, Date fechaCaducidad, Set tratamientos) {
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
		this.tratamientos = tratamientos;
	}

	public Integer getIdMedicamento() {
		return this.idMedicamento;
	}

	public void setIdMedicamento(Integer idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Set getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(Set tratamientos) {
		this.tratamientos = tratamientos;
	}

}
