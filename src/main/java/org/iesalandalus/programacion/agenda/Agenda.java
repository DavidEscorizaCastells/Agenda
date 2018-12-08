package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

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
	
	public void añadir(Contacto contacto) throws OperationNotSupportedException {
		if (buscarPrimerIndiceComprobandoExistencia(contacto)==-1) {
			if (indiceNoSuperaTamaño(numContactos)) {
				contactos[numContactos]=contacto;
				numContactos+=1;
			}	else throw new OperationNotSupportedException ("La agenda está completa.");
		} throw new OperationNotSupportedException ("El contacto "+contacto.toString()+" ya existe.");
		
	}
	
	private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) {;
		for (int i=0;i<contactos.length;i++) {
			if (contactos[i].equals(contacto)) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean indiceNoSuperaTamaño(int indice) {
		if (numContactos>MAX_CONTACTOS) {
			return false;
		}
		return true;
	}
}
