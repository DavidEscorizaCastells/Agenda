package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {

	private static final String ER_TELEFONO="^[6|9]\\d{8}";
	private static final String ER_CORREO="^([\\w])+([\\.\\w]*)@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,5})";
	private String nombre;
	private String telefono;
	private String correo;
	
	public Contacto (String nombre, String telefono, String correo) {
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		if (nombre==null || nombre=="") {
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
		
		if (!m.matches() || telefono==null || telefono=="") {
			throw new IllegalArgumentException ("El número no es válido.");
		} else
			this.telefono=telefono;
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

	public String toString() {
		return getIniciales()+" ["+telefono+", "+correo+"]";
	}
	
	public String getIniciales() {
		String iniciales=""+nombre.charAt(0);
		for (int i=0; i<nombre.length(); i++) {
			if (nombre.charAt(i)==' ') {
				iniciales+=nombre.charAt(i+1);
			}
		}
		return iniciales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
}
