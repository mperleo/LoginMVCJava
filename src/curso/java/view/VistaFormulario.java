package curso.java.view;

import curso.java.model.Usuario;

import java.util.Scanner;

public class VistaFormulario {

	public static Usuario mostrarLogin() {
		Scanner sc = new Scanner(System.in);
		String user = ""; //TODO: scanner
		String pass = ""; //TODO: scanner

		System.out.println("Indica tu usuario");
		user = sc.next();
		System.out.println("Indica tu contraseña");
		pass = sc.next();
		
		Usuario u = new Usuario(user, pass);
		return u;
	}

	public static Usuario mostrarNuevoUsuario() {
		Scanner sc = new Scanner(System.in);
		String user = ""; //TODO: scanner
		String pass = ""; //TODO: scanner
		String pass2 = "";

		boolean seguir = true;

		while(seguir ==true){
			System.out.println("Indica tu usuario");
			user = sc.next();
			System.out.println("Indica tu contraseña");
			pass = sc.next();

			System.out.println("Indica tu contraseña para confirmar");
			pass2 = sc.next();

			// se deberia hacer en el controlador y volver a esta vista si los datos no son correctos
			if(pass.equals(pass2)){
				System.out.println("Contraseñas correctas");
				seguir = false;
			}
		}


		Usuario u = new Usuario(user, pass);
		return u;
	}
}
