
package dao;


import bancodedados.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.postgresql.Driver;
 


public class LogDAO {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // nome do seu banco
    private static final String USUARIO = "postgres"; // seu usuário
    private static final String SENHA = "1234";
    
    private static final String SELECT_SQL = "select * from vw_tabela_log;";
    
    
    public static void main(String[] args){
       
    }
    
    //CRUD
    //READ
    public static ArrayList BuscarLog(){
        ArrayList<Log> logs = new ArrayList();
            
        try {
    
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        
        Connection conectando = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        
        PreparedStatement stmt = conectando.prepareStatement(SELECT_SQL);
        
        ResultSet rs = stmt.executeQuery();
        
        
        while(rs.next()){
            String data = rs.getString("data");
            String horario = rs.getString("horario");
            String acao = rs.getString("acao");
            String tabela = rs.getString("tabela");
            
            Log p = new Log();
            
            p.setData(data);
            p.setHora(horario);
            p.setAcao(acao);
            p.setTabela(tabela);
            
            logs.add(p);
        }
        
        stmt.close();
        conectando.close();
        
        
    } catch(SQLException e){
        e.printStackTrace();
    }
        
        return logs;
    }
}
    //UPDATE
 

    

