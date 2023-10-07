package modelo;

/**
 *
 * @author antonio minero
 */
public class LoginConsulta {
    String tipoDeLogin;//será 1 o 2 dependiendo de si nos logeamos con usuario/contraseña o con codigo
    String usuario;
    String contraseña;
    String codigo;
    String tabla;
    String columna;
    String palabra;
    String orden;
    String infoDelServer;   
    String error; //0  no hay error / 1 para usuario ya registrado / 2 error en las credenciales / 3 ...

    public LoginConsulta() {
    }
    
    public LoginConsulta(String tipoDeLogin, String usuario, String contraseña) {
        this.tipoDeLogin = tipoDeLogin;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getTipoDeLogin() {
        return tipoDeLogin;
    }

    public void setTipoDeLogin(String tipoDeLogin) {
        this.tipoDeLogin = tipoDeLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getInfoDelServer() {
        return infoDelServer;
    }

    public void setInfoDelServer(String infoDelServer) {
        this.infoDelServer = infoDelServer;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
