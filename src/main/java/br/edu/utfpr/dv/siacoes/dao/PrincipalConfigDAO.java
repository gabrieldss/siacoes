package br.edu.utfpr.dv.siacoes.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.edu.utfpr.dv.siacoes.log.UpdateEvent;

public abstract class PrincipalConfigDAO {

public abstract class PrincipalConfigDAO <T> {
    public final T findByDepartment(int idDepartment) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
       try{
            conn=ConnectionDAO.getInstance().getConnection();
            stmt= conn.prepareStatement();

            stmt.setInt(1,idDepartment);
            rs=stmt.executeQuery();

            if(rs.next())
            {
                return this.loadObject(rs);
            }
            else{
                    return null;
                }
        }
        finally{
                   if((rs!=null) && !rs.isClosed())
                   rs.close();
          
                  if((conn!=null) && !conn.isClosed())
                  conn.close();
          
                  if((stmt!=null) && !stmt.isClosed())
                  stmt.close();
            }
       }
  
    public final int save(int idUser,T config) throws SQLException{
        Connection conn=null;
        PreparedStatement stmt=null;
        boolean insert=(this.findByDepartment(config.getDepartment().getIdDepartment())==null);
      
       try{
            conn=ConnectionDAO.getInstance().getConnection();
            if(insert)
            {
                stmt=conn.prepareStatement();
            }
            else{
                    stmt=conn.prepareStatement();
                }

            stmt.execute();
            new UpdateEvent(conn).registerUpdate(idUser,config);

            return config.getDepartment().getIdDepartment();
        }
        finally{
                  if((conn!=null) && !conn.isClosed())
                  conn.close();
          
                  if((stmt!=null) && !stmt.isClosed())
                  stmt.close();    
          }
      }
  
    protected final T loadObject(ResultSet rs) throws SQLException{
        return null;
    }
  }
}
