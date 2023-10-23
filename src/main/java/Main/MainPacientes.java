package Main;

import Entidades.Paciente;
import datos.*;
import java.sql.*;
import java.util.List;

public class MainPacientes {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            IPacienteDAO pacienteDao = new PacienteDaoJDBC();
            //select patient.
//            List<Paciente> paciente = pacienteDao.select();
//            paciente.forEach(pacientes -> {
//                System.out.println("pacientes = " + pacientes);
//            });
            //add patient.
//            Paciente newPatient = new Paciente("Rolfo Javier", "40400011", 370423533);
//            pacienteDao.insert(newPatient);
//          Update patient.
//            Paciente pacienteUpdate = new Paciente(1, "Raul", "111111", 312414150);
//            pacienteDao.update(pacienteUpdate);
            //Delete Patient.
//            Paciente pacienteEliminar = new Paciente(5);
//            pacienteDao.delete(pacienteEliminar);

            conexion.commit();
        } catch (SQLException ex) {
            try {
                ex.printStackTrace(System.out);
                System.out.println("A RollBack has been made.");
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
