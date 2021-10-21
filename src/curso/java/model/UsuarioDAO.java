package curso.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UsuarioDAO {
    public static ArrayList<Usuario> leerUsuariosDeFichero(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        BufferedReader buffer;
        String linea;

        try {
            FileReader file = new FileReader("./usuarios/usuarios.txt");
            buffer = new BufferedReader(file);
            while ((linea=buffer.readLine()) != null) {
                StringTokenizer strtokens = new StringTokenizer(linea,":");
                if(strtokens.hasMoreTokens()){
                    String nusuario = strtokens.nextToken();
                    String contr = strtokens.nextToken();
                    Usuario usuario = new Usuario(nusuario ,contr);
                    usuarios.add(usuario);    // Guardamos la linea en un String
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public static void escribirUsuarioEnFichero(Usuario usuario){
        BufferedWriter buffer;
        String linea;

        try {
            FileWriter file = new FileWriter("./usuarios/usuarios.txt",true);
            buffer = new BufferedWriter(file);
            buffer.newLine();
            linea = usuario.getUser()+":"+usuario.getPass();
            buffer.write(linea);
            buffer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
