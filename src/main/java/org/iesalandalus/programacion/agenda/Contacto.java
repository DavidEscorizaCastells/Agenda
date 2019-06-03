package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {

	private static final String ER_TELEFONO="^[6|9]\\d{8}";
	private static final String ER_CORREO="^([\\w])+([\\.\\w]*)@([A-Za-z]+)(\\.[A-Za-z]+)*(\\.[A-Za-z]{1,5})";
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
		if (nombre==null || nombre.trim().equals("")) {
			throw new IllegalArgumentException ("El nombre de un contacto no puede ser nulo o vacío.");
		} else 
			this.nombre=nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		
		if (telefono==null || telefono.trim().equals("")) {
			throw new IllegalArgumentException ("El teléfono de un contacto no puede ser nulo o vacío.");
		}
		
		Pattern p=Pattern.compile(ER_TELEFONO);
		Matcher m=p.matcher(telefono);
		
		if (!m.matches()) {
			throw new IllegalArgumentException ("El teléfono no tiene un formato válido.");
		} else {
			this.telefono=telefono;
		}
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		
		if (correo==null || correo.trim().equals("")) {
			throw new IllegalArgumentException ("El correo de un contacto no puede ser nulo o vacío.");
		}
		Pattern p=Pattern.compile(ER_CORREO);
		Matcher m=p.matcher(correo);
				
		if (!m.matches()) {
			throw new IllegalArgumentException ("El correo no tiene un formato válido.");
		} else
			this.correo=correo;
	}

	public String toString() {
		return getIniciales()+" ["+telefono+", "+correo+"]";
	}
	
	public String getIniciales() {
		String[] partes = nombre.split("\\s+");
		String iniciales="";
		
		for (int i=0; i<partes.length;i++)
			iniciales+=partes[i].toUpperCase().charAt(0);
		
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
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}
	
	
	
}
