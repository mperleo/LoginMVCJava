package curso.java.controller;

import curso.java.model.Usuario;
import curso.java.model.UsuarioDAO;
import curso.java.view.VistaFormulario;
import curso.java.view.VistaMenu;

import java.util.ArrayList;

public class Login {
	
	public static void main(String[] args) {
		
		int opcion = VistaMenu.mostrar();
		int veces = 5; // variable para contar las veces que se hace el intento de login
		
		switch (opcion) {
		//Loguin
		case 1:
			while(veces >0){

				Usuario usuario = VistaFormulario.mostrarLogin();
				boolean existe = existeUsuario(usuario.getUser());

				//El usuario existe en el repositorio
				if(existe) {
					//TODO: comprobar contraseña:
					if(comprobarContras(usuario)){
						//TODO: 1_ contraseña correcta -> vista OK
						VistaMenu.mostrarLogin(usuario);
					}
					else{
						//TODO: 2_ contraseña incorrecta (número de intentos) -> volver al formulario y mensaje apropiado
						VistaMenu.mostrarLoginError(2);
						veces--;
					}

				}
				//El usuario no existe en el repositorio
				else {
					//TODO: vista no OK -> volver al formulario y mensaje apropiado
					VistaMenu.mostrarLoginError(1);
					veces--;
				}
			}
			break;
		//Alta
		case 2:
			//TODO: implementar el alta
			Usuario nuevo = VistaFormulario.mostrarNuevoUsuario();
			UsuarioDAO.escribirUsuarioEnFichero(nuevo);
			VistaMenu.mostrarNuevoUsuario(nuevo);
			// guardar nuevo en la BBDD despues de comprobar los datos

			
			break;
		default:
			break;
		}
	}
	
	public static boolean existeUsuario(String user) {
		boolean resultado = false;

		ArrayList<Usuario> usuarios = UsuarioDAO.leerUsuariosDeFichero();

		for(Usuario i: usuarios){
			//comprobar que el usuaro existe (se valida contra los valores de las constantes):
			if(user.equals(i.getUser())){
				//el usuario existe -> resultado = true;
				resultado= true;
				return resultado;
			}
		}

		//el usuario no existe -> resultado = false; (ya está con este valor por defecto)

		return resultado;
	}

	public static boolean comprobarContras(Usuario userForm){
		boolean resultado = false;

		ArrayList<Usuario> usuarios = UsuarioDAO.leerUsuariosDeFichero();

		for(Usuario i: usuarios){
			//comprobar que el usuaro existe (se valida contra los valores de las constantes):
			if(userForm.equals(i.getUser())){
				//el usuario existe -> resultado = true;
				if(userForm.getPass().equals(i.getPass())){
					resultado= true;
					return resultado;
				}
			}
		}
		return resultado;
	}

}
