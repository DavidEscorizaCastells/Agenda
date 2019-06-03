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
	
	public void anadir(Contacto contacto) throws OperationNotSupportedException {
		contactos[buscarPrimerIndiceComprobandoExistencia(contacto)]=contacto;
		numContactos+=1;
	}
	
	private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) throws OperationNotSupportedException {;
		for (int i=0;i<contactos.length;i++) {
			if (contactos[i]==contacto) {
				throw new OperationNotSupportedException ("Ya existe un contacto con ese nombre.");
			}
			if (contactos[i]==null) {
				return i;
			}
		}
		throw new OperationNotSupportedException ("La agenda está completa.");
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		if (numContactos>MAX_CONTACTOS) {
			return false;
		}
		return true;
	}
	
	public Contacto buscar(String nombre) {
		if (buscarIndiceCliente(nombre)!=-1) {
			return contactos[buscarIndiceCliente(nombre)];
		} else return null;
	}
	
	private int buscarIndiceCliente(String nombre) {
		String telefonoValido="999999999";
		String correoValido="a1@b.c";
		Contacto contactoBuscado=new Contacto (nombre, telefonoValido, correoValido);
		for (int i=0; i<numContactos;i++) {
			if (contactos[i].equals(contactoBuscado)) {
				return i;
			}
		}
		return -1;
	}
	
	public void borrar(String nombre) throws OperationNotSupportedException {
		if (buscarIndiceCliente(nombre)==-1)
			throw new OperationNotSupportedException ("El contacto a borrar no existe.");
		else 
			desplazarUnaPosicionHaciaLaIzquierda(buscarIndiceCliente(nombre));
			numContactos-=1;
	}
	
	private void desplazarUnaPosicionHaciaLaIzquierda(int indice){
		for (int i=indice; i<MAX_CONTACTOS-1; i++) {
			contactos[i]=contactos[i+1];
			contactos[i+1]=null;
		}
	}
}
