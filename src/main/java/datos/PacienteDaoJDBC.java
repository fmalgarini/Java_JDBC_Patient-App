package datos;

import Entidades.Paciente;
import java.sql.*;
import java.util.*;

public class PacienteDaoJDBC implements IPacienteDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_turno, nombre_paciente, dni_paciente, telefono FROM pacientes.turnos";
    private static final String SQL_INSERT = "INSERT INTO pacientes.turnos(nombre_paciente, dni_paciente, telefono) VALUES(? , ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pacientes.turnos SET nombre_paciente = ?, dni_paciente = ?, telefono = ? WHERE id_turno = ?";
    private static final String SQL_DELETE = "DELETE FROM pacientes.turnos WHERE id_turno = ?";

    @Override

    public List<Paciente> select() throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> pacientes = new ArrayList<>();

        pstmt = conn.prepareStatement(SQL_SELECT);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            int turnoPaciente = rs.getInt("id_turno");
            String nombrePaciente = rs.getString("nombre_paciente");
            String dniPaciente = rs.getString("dni_paciente");
            int telefonoPaciente = rs.getInt("telefono");

            paciente = new Paciente(turnoPaciente, nombrePaciente, dniPaciente, telefonoPaciente);
            pacientes.add(paciente);
        }
        Conexion.close(rs);
        Conexion.close(pstmt);

        if (this.conexionTransaccional == null) {
            Conexion.close(conn);
        }
        return pacientes;
    }

    @Override

    public int insert(Paciente paciente) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement pstmt = null;
        int registros = 0;

        pstmt = conn.prepareStatement(SQL_INSERT);
        pstmt.setString(1, paciente.getNombrePaciente());
        pstmt.setString(2, paciente.getDniPaciente());
        pstmt.setInt(3, paciente.getTelefonoPaciente());

        registros = pstmt.executeUpdate();
        Conexion.close(pstmt);

        if (this.conexionTransaccional == null) {
            Conexion.close(conn);
        }

        return registros;
    }

    @Override
    public int update(Paciente paciente) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement pstmt = null;
        int registros = 0;
        pstmt = conn.prepareStatement(SQL_UPDATE);
        pstmt.setString(1, paciente.getNombrePaciente());
        pstmt.setString(2, paciente.getDniPaciente());
        pstmt.setInt(3, paciente.getTelefonoPaciente());
        pstmt.setInt(4, paciente.getIdTurno());

        registros = pstmt.executeUpdate();
        Conexion.close(pstmt);

        if (conexionTransaccional == null) {
            Conexion.close(conn);
        }
        return registros;

    }

    @Override
    public int delete(Paciente paciente) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement pstmt = null;
        int registros = 0;

        pstmt = conn.prepareStatement(SQL_DELETE);
        pstmt.setInt(1, paciente.getIdTurno());

        registros = pstmt.executeUpdate();
        Conexion.close(pstmt);

        if (this.conexionTransaccional == null) {
            Conexion.close(conn);
        }

        return registros;
    }

}
