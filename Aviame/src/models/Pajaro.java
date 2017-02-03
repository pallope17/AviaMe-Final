package models;
// Generated 02-feb-2017 13:48:33 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Pajaro generated by hbm2java
 */
public class Pajaro implements java.io.Serializable {

	private Integer idPajaro;
	private Pajaro pajaro;
	private Usuario usuario;
	private String especie;
	private String sexo;
	private String color;
	private String observaciones;
	private Set enfermedads = new HashSet(0);
	private Set pajaros = new HashSet(0);

	public Pajaro() {
	}

	public Pajaro(Pajaro pajaro, Usuario usuario, String especie, String sexo, String color, String observaciones,
			Set enfermedads, Set pajaros) {
		this.pajaro = pajaro;
		this.usuario = usuario;
		this.especie = especie;
		this.sexo = sexo;
		this.color = color;
		this.observaciones = observaciones;
		this.enfermedads = enfermedads;
		this.pajaros = pajaros;
	}

	public Integer getIdPajaro() {
		return this.idPajaro;
	}

	public void setIdPajaro(Integer idPajaro) {
		this.idPajaro = idPajaro;
	}

	public Pajaro getPajaro() {
		return this.pajaro;
	}

	public void setPajaro(Pajaro pajaro) {
		this.pajaro = pajaro;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(Set enfermedads) {
		this.enfermedads = enfermedads;
	}

	public Set getPajaros() {
		return this.pajaros;
	}

	public void setPajaros(Set pajaros) {
		this.pajaros = pajaros;
	}

}
