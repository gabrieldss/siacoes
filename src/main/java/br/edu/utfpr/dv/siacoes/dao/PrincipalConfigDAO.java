package br.edu.utfpr.dv.siacoes.dao;

public abstract class PrincipalConfigDAO {
  import java.sql.ResultSet;
  import java.sql.SQLException;

public abstract class PrincipalConfigDAO <T> {
    public T findByDepartment(int idDepartment) throws SQLException {
        return null;
    }
    public int save(int idUser, T config) throws SQLException{
        return 1;
    }
    protected T loadObject(ResultSet rs) throws SQLException{
        return null;
    }
  }
}
