package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.*;
/**
 *
 * @author Andrés
 */
public class BaseDatos {
    Connection con = null;
    Statement stm = null;
    ResultSet r = null;
    
    public String Conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        String mensaje;
        try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost/LoginPractica", "root", "n0m3l0");
                stm = con.createStatement();
                mensaje = "Conexión exitosa";
            }catch (SQLException error){
                mensaje = error.toString();
            }
        return mensaje;
    }
    
    public Boolean BuscarUsuario(String Nombre, String Pass ) throws SQLException
    {
        Boolean VerExist = false;
        r = stm.executeQuery("SELECT * FROM Usuarios;");
        
        while(r.next())
        {
            if(Nombre.equals(r.getString("NombreUsuario")) && Pass.equals(r.getString("PassUsuario")))
            {
                VerExist = true;
            }
        }
        
        return VerExist;
    }
}
