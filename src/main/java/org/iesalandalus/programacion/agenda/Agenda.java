package org.iesalandalus.programacion.agenda;

public class Agenda {
	
	private static final int MAX_CONTACTOS=20;
	int numContactos;
	Contacto[] contactos;
	
	public Agenda () {
		numContactos=0;
		contactos=new Contacto[MAX_CONTACTOS];
	}
	
	public Contacto[] getContactos() {
		Contacto[] copiaContactos = new Contacto[MAX_CONTACTOS];
		for (int i=0; i<copiaContactos.length; i++) {
			copiaContactos[i]=contactos[i];
		}		
		return copiaContactos;
	}
	
	public int getNumContactos() {
		return numContactos;
	}
}
