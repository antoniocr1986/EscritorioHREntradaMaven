package modelo;

/**
 *
 * @author Antonio Company Rodriguez
 */
public class UserTipe {
    private int numTipe;
    private String tipo;

    public UserTipe(int numTipe, String tipo) {
        this.numTipe = numTipe;
        this.tipo = tipo;
    }

    public int getNumTipe() {
        return numTipe;
    }

    public void setNumTipe(int numTipe) {
        this.numTipe = numTipe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
