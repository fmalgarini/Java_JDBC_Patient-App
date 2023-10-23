package Entidades;

public class Paciente {

    private int idTurno;
    private String nombrePaciente;
    private String dniPaciente;
    private int telefonoPaciente;

    public Paciente() {
    }

    public Paciente(int idTurno) {
        this.idTurno = idTurno;
    }

    public Paciente(String nombrePaciente, String dniPaciente, int telefonoPaciente) {
        this.nombrePaciente = nombrePaciente;
        this.dniPaciente = dniPaciente;
        this.telefonoPaciente = telefonoPaciente;
    }

    public Paciente(int idTurno, String nombrePaciente, String dniPaciente, int telefonoPaciente) {
        this.idTurno = idTurno;
        this.nombrePaciente = nombrePaciente;
        this.dniPaciente = dniPaciente;
        this.telefonoPaciente = telefonoPaciente;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public int getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(int telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "idTurno=" + idTurno + ", nombrePaciente=" + nombrePaciente + ", dniPaciente=" + dniPaciente + ", telefonoPaciente=" + telefonoPaciente + '}';
    }

}
