package curso.java.model;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import curso.Conexion;

public class UsuarioDAO {
    public static ArrayList<Usuario> seleccionarUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        Connection con = Conexion.getConexion();
    

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios");
	        
	        ResultSet resultado = ps.executeQuery();
	        
	        while(resultado.next()) {
	        	Usuario usuario = new Usuario(resultado.getString("user"), resultado.getString("pass"));  

	            usuarios.add(usuario);
	        }
	        ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        Conexion.desconectar();
        return usuarios;
    }

    public static void insertarUsuario(Usuario usuario){
    	Connection con = Conexion.getConexion();
    	
    	PreparedStatement ps;


        try {
    		ps = con.prepareStatement("INSERT INTO usuarios (user, pass) " + "VALUES (?, ?)");

            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPass());

        	int resultado = ps.executeUpdate();

            if (resultado == 0) {
                System.out.println("NO se ha podido insertar");
            }

            ps.close();
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Conexion.desconectar();


    }
}
