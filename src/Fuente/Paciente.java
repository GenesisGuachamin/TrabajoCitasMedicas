/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuente;
/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */

import javax.swing.JOptionPane;

public final class Paciente {
	
	public int id;
	public String nombre;
	public String apellidos;
	public int edad;
	public String genero;
	
	public Paciente(int id, String nombre, String apellidos, int edad, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Muestra en un panel todos los datos del Paciente
	 */
	public void mostrar() {
		String mensaje = "ID Paciente: " + id + "\nNombre: " + nombre
				+ "\nApellidos: " + apellidos + "\nEdad: " + edad
				+ "\nGenero: " + genero;
		JOptionPane.showMessageDialog(null, mensaje, "Mostrar Paciente", JOptionPane.INFORMATION_MESSAGE);
	}

}
