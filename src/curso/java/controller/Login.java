package curso.java.controller;

import curso.java.model.Usuario;
import curso.java.view.VistaFormulario;
import curso.java.view.VistaMenu;

public class Login {

	public static final String USER = "admin";
	public static final String PASS = "admin";
	
	public static void main(String[] args) {
		
		int opcion = VistaMenu.mostrar();
		int veces = 0; // variable para contar las veces que se hace el intento de login
		
		switch (opcion) {
		//Loguin
		case 1:
			while(veces >0){

				Usuario usuario = VistaFormulario.mostrarLogin();
				boolean existe = existeUsuario(usuario.getUser());

				//El usuario existe en el repositorio
				if(existe) {
					//TODO: comprobar contraseña:
					if(comprobarContraseña(usuario)){
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
			// guardar nuevo en la BBDD despues de comprobar los datos

			
			break;
		default:
			break;
		}
	}
	
	public static boolean existeUsuario(String user) {
		boolean resultado = false;
		//TODO: comprobar que el usuaro existe (se valida contra los valores de las constantes):
		if(user.equals(USER)){
			//TODO: 1_ el usuario existe -> resultado = true;
			resultado= true;
		}
		//TODO: 2_ el usuario no existe -> resultado = false; (ya está con este valor por defecto)

		return resultado;
	}

	public static boolean comprobarContraseña(Usuario userForm){
		boolean resultado = false;
		if(userForm.equals(USER)){
			//TODO: 1_ el usuario existe -> resultado = true;
			resultado= true;
			if(userForm.getPass().equals(PASS)){
				resultado = true;
			}
		}
		return resultado;
	}

}
