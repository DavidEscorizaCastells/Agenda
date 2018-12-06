package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {

	private static final String ER_TELEFONO="^[6|9]\\d{8}";
	private static final String ER_CORREO="^([\\w])+([\\.\\w]*)@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,5})";
	private String nombre;
	private String telefono;
	private String correo;
	
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		if (nombre.equals(null) || nombre.equals("")) {
			throw new IllegalArgumentException ("El nombre no puede estar vacío.");
		} else 
			this.nombre=nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		Pattern p=Pattern.compile(ER_TELEFONO);
		Matcher m=p.matcher(telefono);
		
		if (m.matches()) {
			this.telefono=telefono;
		} else
			throw new IllegalArgumentException ("El número no es válido.");
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		Pattern p=Pattern.compile(ER_CORREO);
		Matcher m=p.matcher(correo);
		
		if (m.matches()) {
			this.correo=correo;
		} else
			throw new IllegalArgumentException ("El correo no es válido.");
	}

	
	
	
	
}
