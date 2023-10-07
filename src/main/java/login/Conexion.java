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

/**
 *
 * @author antonio minero
 */
public class Conexion {
    Connection conn = null;
    
    String user = "admin";
    String password = "admin";
    String bd ="HREntrada2";
    String puerto ="5432";
    String ip = "";
    String admin = "gus";
    
    //String connectionString = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    // Crear un ArrayList de objetos User
    private static ArrayList<User> userList = new ArrayList<>();

    public Conexion(String ip) {
        this.ip = ip;
    }
    
    
    
    public Connection getConexion(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://"+this.ip+":"+puerto+"/"+bd,user,password);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al conectar a la BD, error: "+ex.toString());          
        }     
        return conn;
    }
    
    public boolean verificarCredenciales(String usuario, String contrasena) {
        try {
            // Consulta SQL para buscar un user con las credenciales proporcionadas
            String sql = "SELECT * FROM users WHERE login = ? AND pass = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            // Si se encuentra un resultado, las credenciales son válidas
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar las credenciales, error: " + ex.toString());
        }
        return false; // Si no se encuentra ningún resultado, las credenciales no son válidas
    }
    
    public boolean isAdmin(String usuario, String contraseña){
        if (usuario.equals(admin)){
            return true;
        }else{
            return false;
        }
    }
    
    //***GUS Método para comprobar login por sockets   
    public void entrar(String usuario, String contraseña){
        MainForm principal = new MainForm();
        boolean salir = false;
        try {
            //IMPLEMENTA
            Socket socket = new Socket("192.168.0.20", 5432);
            // Scanner lectorPalabra = new Scanner(System.in);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));//flujo lectura del server
            BufferedWriter escriptor = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//flujo envio al server
            BufferedWriter asdf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//flujo envio al server
            ///Llegeix del servidor el mensaje de bienvenida, y la pregunta que nos hace ///           

            String mensajeServer = lector.readLine();
            System.out.println(mensajeServer);
            //ahora escribimos en servidor , enviandole la palabra a buscar 
            escriptor.write(usuario);
            escriptor.newLine();
            escriptor.flush();

            asdf.write(contraseña);
            asdf.newLine();
            asdf.flush();

            if (usuario.equalsIgnoreCase("exit")) {
                salir = true;
                lector.close();
                escriptor.close();
                socket.close();

            } else {
                //recibimos la respuesta
                mensajeServer = lector.readLine();
                principal.setVisible(true);
            }
            socket.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //***Primeros pasos para loguearme con sockets.
    public void logInSockets(String usuario, String contraseña){
       userList.add(new User (usuario,contraseña));
       
       //Ahora querremo enviar este user creado al logearnos por sockets al servidor
       for (User user: userList){
           JOptionPane.showMessageDialog(null,"Usuario creado como objeto: "+user.toString());
           JOptionPane.showMessageDialog(null,"Nombre: "+user.getLogin()+"\nPassword: "+user.getPass());
       }     
    }
}