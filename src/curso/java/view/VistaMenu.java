package curso.java.view;

import curso.java.model.Usuario;

import java.util.Scanner;

public class VistaMenu {

	public static int mostrar() {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		//TODO: menú de login
		//1. Logar
		//opcion = 1;
		//2. Dar de alta
		
		//TODO: se captura la opción que introduce el usuario

		System.out.println("Indica una opcion:");
		System.out.println("1- Iniciar sesion");
		System.out.println("2- Registrarme ");
		System.out.println("3- Salir ");
		opcion = sc.nextInt();
		
		return opcion;
	}

	public static void mostrarLogin(Usuario usuario) {
		System.out.println("Login correcto");
		System.out.println("Usuario: "+usuario.getUser());
		System.out.println("Contraseña: "+ usuario.getPass());

	}

	public static void mostrarNuevoUsuario(Usuario usuario) {
		System.out.println("La cuenta se ha creado correctamente");
		System.out.println("Usuario: "+usuario.getUser());
		System.out.println("Contraseña: "+ usuario.getPass());

	}

	public static void mostrarLoginError(int opcion) {
		if(opcion == 1){
			System.out.println("Usuario no encontrado");
		}else{
			System.out.println("Contraseña incorrecta");
		}
	}

}
