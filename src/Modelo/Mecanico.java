package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.sql.*;


public class Mecanico {
    
    //1. Parametros
    
    private String uuidMecanico;
    private String Nombre;
    private String Correo;
    private String Contraseña;

    
    //2. Getters y Setters
    public String getUuidMecanico() {
        return uuidMecanico;
    }

    public void setUuidMecanico(String uuidMecanico) {
        this.uuidMecanico = uuidMecanico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    //3 Metodos
    public void GuardarMecanico() {
        
        Connection conexion = ClaseConexion.getConexion();
        
        try{
            PreparedStatement addMecanico = conexion.prepareStatement("insert into Mecanico (uuidMecanico, nombre, correo, contraseña) values (?, ?, ?, ?)");
            
            addMecanico.setString(1, UUID.randomUUID().toString());
            addMecanico.setString(2, getNombre());
            addMecanico.setString(3, getCorreo());
            addMecanico.setString(4, getContraseña());
            
            addMecanico.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error al guardar mecanico" + ex);
        }
    }
    
    public boolean IniciarSesion(){
        Connection conexion = ClaseConexion.getConexion();
        
        boolean resultado = false;
        
        try{
            String sql = "SELECT * FROM Mecanico WHERE correo = ? AND contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo());
            statement.setString(2, getContraseña());
            
            ResultSet resultset = statement.executeQuery();
            
            if (resultset.next()) {
                resultado = true;
            }  
        } catch(SQLException ex){
            System.out.println("Error al Iniciar Sesion" + ex);
        }
        
        return resultado;
    }
}
