package curso.java.controller;

import curso.java.model.Usuario;
import curso.java.model.UsuarioDAO;
import curso.java.view.VistaFormulario;
import curso.java.view.VistaMenu;

import java.util.ArrayList;

public class Login {
	
	public static void main(String[] args) {
		int veces = 5; // variable para contar las veces que se hace el intento de login
		boolean seguir = true;
		
		do {
			int opcion = VistaMenu.mostrar();
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
							veces = 0;
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
				UsuarioDAO.insertarUsuario(nuevo);
				VistaMenu.mostrarNuevoUsuario(nuevo);
				// guardar nuevo en la BBDD despues de comprobar los datos
				break;
			case 3:
				seguir = false;
				break;
			default:
				break;
			}
		}while(seguir == true)	;
		
	}
	
	public static boolean existeUsuario(String user) {
		boolean resultado = false;

		ArrayList<Usuario> usuarios = UsuarioDAO.seleccionarUsuarios();

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

		ArrayList<Usuario> usuarios = UsuarioDAO.seleccionarUsuarios();

		for(Usuario i: usuarios){
			//comprobar que el usuaro existe (se valida contra los valores de las constantes):
			if(userForm.getUser().equals(i.getUser())){
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
