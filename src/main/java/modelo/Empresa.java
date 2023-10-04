package modelo;

/**
 *
 * @author Antonio Company Rodríguez
 */
public class Empresa {
    private String nom;
    private String address;
    private int telephone;

    public Empresa(String nom, String address, int telephone) {
        this.nom = nom;
        this.address = address;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
}
