package modelo;
import java.time.*;
import java.sql.*;

/**
 *
 * @author antonio minero
 */
public class Jornada {
    private String dni;
    private String nom;
    private String apellido;
    private int codiCard;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Duration totalTiempo;
    private Date fecha;

    public Jornada(String dni, String nom, String apellido, int codiCard, LocalDateTime horaEntrada, LocalDateTime horaSalida, Duration totalTiempo, Date fecha) {
        this.dni = dni;
        this.nom = nom;
        this.apellido = apellido;
        this.codiCard = codiCard;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.totalTiempo = totalTiempo;
        this.fecha = fecha;
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

    public int getCodiCard() {
        return codiCard;
    }

    public void setCodiCard(int codiCard) {
        this.codiCard = codiCard;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Duration getTotalTiempo() {
        return totalTiempo;
    }

    public void setTotalTiempo(Duration totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
