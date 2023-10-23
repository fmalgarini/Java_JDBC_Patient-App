package datos;

import Entidades.Paciente;
import java.sql.SQLException;
import java.util.List;

public interface IPacienteDAO {

    public List<Paciente> select() throws SQLException;

    public int insert(Paciente paciente) throws SQLException;

    public int update(Paciente paciente) throws SQLException;

    public int delete(Paciente paciente) throws SQLException;
}
