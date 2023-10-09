package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.User;
import vistas.MainForm;
import java.util.ArrayList;
import vistas.FormUsuarioAdmin;
import vistas.MainForm;

/**
 *
 * @author antonio minero
 */
public class ConexionBDLocal {
    Connection conn = null;
    
    String user = "admin";
    String password = "admin";
    String bd ="HREntrada2";
    String puerto ="5432";
    String ip = "";
    String admin = "gus"; //Substituir por datos en BD del user admin
    
    //  predefined codes
    private static final int OK_RETURN_CODE_ADMIN = 0;  //usuario admin
    public static final int OK_RETURN_CODE_USER = 1; //usuario
    public static final int ERROR_RETURN_CODE = -1;  //no identificado
    
    //String connectionString = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    // Crear un ArrayList de objetos User
    private static ArrayList<User> userList = new ArrayList<>();

    public ConexionBDLocal(String ip) {
        this.ip = ip;
    }
    
    public Connection getConexion() throws ClassNotFoundException, SQLException{         
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://"+this.ip+":"+puerto+"/"+bd,user,password);    
        return conn;
    }
    
    //***Primeros pasos para loguearme con sockets.
    public void logInSocketsInfo(String usuario, String contraseña){
       userList.add(new User (usuario,contraseña));
       
       //Ahora querremo enviar este user creado al logearnos por sockets al servidor
       for (User user: userList){
           JOptionPane.showMessageDialog(null,"Usuario creado como objeto: "+user.toString()
                   +"\nNombre: "+user.getLogin()+"\nPassword: "+user.getPass());
       }     
    }
    
    //Comprobamos credenciales con la BD local
    public int verificarCredencialesBDLocal(String usuario, String contrasena) {
        try {
            // Consulta SQL para buscar un user con las credenciales proporcionadas
            String sql = "SELECT * FROM users WHERE login = ? AND pass = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            // Si se encuentra un resultado, las credenciales son válidas
            if (resultSet.next()) {
                if (usuario.equals(admin)){
                    return OK_RETURN_CODE_ADMIN;
                }else{
                    return OK_RETURN_CODE_USER;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar las credenciales, error: " + ex.toString());
        }
        return ERROR_RETURN_CODE; // Si no se encuentra ningún resultado, las credenciales no son válidas
    }
}