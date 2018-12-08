package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static final String ERROR="La operación no ha podido realizarse. ";
	private static final String EXITO="La operacion se ha realizado con éxito. ";
	private static Agenda miAgenda=new Agenda();
	
	public static void main(String[] args) {
		System.out.println("Programa para gestionar una agenda de contactos");
		int opcion;
		do {
			mostrarMenu();
			opcion=elegirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion!=0);
		
		
		
	}
	
	private static void mostrarMenu() {
		System.out.println("Opciones:");
		System.out.println("1.Añadir contacto.");
		System.out.println("2.Buscar contacto.");
		System.out.println("3.Borrar contacto.");
		System.out.println("4.Listar contactos.");
		System.out.println("0.Salir");
		
		
	}
	
	private static int elegirOpcion() {
		int opcion;
		do {
			System.out.println("Selecciona la opción que desees realizar:");
			opcion=Entrada.entero();		
		} while (opcion<0 && opcion>4);
			return opcion;
	}
	
	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			anadirContacto();
			break;
		case 2:
			buscarContacto();
			break;
		case 3:
			borrarContacto();
			break;
		case 4:
			listarAgenda();
			break;
		case 0:	
			break;
		}
	}
	
	private static void anadirContacto() {
		System.out.print("Nombre: ");
		String nombre=Entrada.cadena();
		System.out.print("Teléfono: ");
		String telefono=Entrada.cadena();
		System.out.print("Correo: ");
		String correo=Entrada.cadena();
		
		try {
			Contacto nuevoContacto=new Contacto (nombre, telefono, correo);
			miAgenda.anadir(nuevoContacto);
			System.out.println(EXITO);
		} catch  (IllegalArgumentException e) {
			System.out.println(ERROR+e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+e.getMessage());
		}
	}
	
	private static void buscarContacto() {
		System.out.print("Nombre: ");
		String nombre=Entrada.cadena();
		
		if (miAgenda.buscar(nombre)==null){
			System.out.println(ERROR+"El contacto no existe.");
		} else {
			System.out.println(EXITO);
			System.out.println(miAgenda.buscar(nombre).toString());
		}			
	}
	
	private static void borrarContacto() {
		System.out.print("Nombre: ");
		String nombre=Entrada.cadena();
		
		try {
			miAgenda.borrar(nombre);
			System.out.println(EXITO);
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+e.getMessage());
		}		
	}
	
	private static void listarAgenda() {
		if (miAgenda.numContactos==0)
			System.out.println(ERROR+"La agenda está vacía.");
		else		
			for (int i=0; i<miAgenda.numContactos; i++) {
				System.out.println(miAgenda.contactos[i].toString());
			}
	}
	
	
	
	
	
	
}
