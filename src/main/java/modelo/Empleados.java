package modelo;

/**
 *
 * @author antonio minero
 */
public class Empleados {
    private String dni;
    private String nom;
    private String apellido;
    private String nomEmpresa;
    private String departament;
    private int codiCard;
    private String mail;
    private int telephone;

    public Empleados(String dni, String nom, String apellido, String nomEmpresa, String departament, int codiCard, String mail, int telephone) {
        this.dni = dni;
        this.nom = nom;
        this.apellido = apellido;
        this.nomEmpresa = nomEmpresa;
        this.departament = departament;
        this.codiCard = codiCard;
        this.mail = mail;
        this.telephone = telephone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public int getCodiCard() {
        return codiCard;
    }

    public void setCodiCard(int codiCard) {
        this.codiCard = codiCard;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
}
