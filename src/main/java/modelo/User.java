package modelo;

/**
 *
 * @author antonio minero
 */
public class User {
    private String login;
    private String pass;
    private int numType;
    private String dni;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;       
    }  

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getNumType() {
        return numType;
    }

    public void setNumType(int numType) {
        this.numType = numType;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }  
}
