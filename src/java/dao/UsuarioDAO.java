
package dao;


import bancodedados.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.postgresql.Driver;
import java.sql.ResultSet;
 


public class UsuarioDAO {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // nome do seu banco
    private static final String USUARIO = "postgres"; // seu usuário
    private static final String SENHA = "1234";
    
    private static final String INSERT_SQL = "INSERT INTO usuarios (email, senha) VALUES (?, ?)";
    private static final String SELECT_SQL = "select * from usuarios where email = ?";
    private static final String UPDATE_SQL = "UPDATE usuarios SET email = ?, senha = ? WHERE id_usuario = ?";
    private static final String DELETE_SQL = "delete from usuarios WHERE id_usuario= ?";
    
    
    public static void main(String[] args){
        //BuscarUsuarios();
        //InserirUsuario();
        //AtualizarUsuario();
        //DeletarUsuario();

    }
    
    //CRUD
    public static Usuario BuscarUsuario(String email){
        Usuario u = new Usuario();
        try {
    
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        
        Connection conectando = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        
        PreparedStatement stmt = conectando.prepareStatement(SELECT_SQL);
         stmt.setString(1, email);
         
        
        
         
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
        
            int id = rs.getInt("id_usuario");
            String senha = rs.getString("senha");
            String emailBD = rs.getString("email");
            
            u.setId(id);
            u.setSenha(senha);
            u.setEmail(emailBD);
        }
        
        stmt.close();
        conectando.close();
        
        
    } catch(SQLException e){
        e.printStackTrace();
    }
        
       return u; 
    }
    
    //CREATE
    public static boolean InserirUsuario(Usuario usuario){
        
        boolean sucesso = false;
        
        try {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection c = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        PreparedStatement stmt = c.prepareStatement(INSERT_SQL);
        
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, usuario.getSenha());

        
         int rowsAffect = stmt.executeUpdate();
         
            if (rowsAffect > 0) {
                sucesso = true;
            }
         
        stmt.close();
        c.close();
        
        
    } catch(SQLException e){
        e.printStackTrace();
    }
        return sucesso;
 }
    
    //UPDATE
    public static boolean AtualizarUsuario(Usuario usuario){
        boolean sucesso = false;
        try {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        
        Connection c = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        
        PreparedStatement stmt = c.prepareStatement(UPDATE_SQL);
        
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, usuario.getSenha());
        stmt.setInt(5, usuario.getId());
        
         int rowsAffect = stmt.executeUpdate();
         
            if (rowsAffect > 0) {
                sucesso = true;
            }
         
        stmt.close();
        c.close();
        
        
    } catch(SQLException e){
        e.printStackTrace();
    }
        
        return sucesso;
    }
    
    //DELETE
    public static boolean DeletarUsuario(Usuario usuario){
        boolean sucesso = false;
        try {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        
        Connection c = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        PreparedStatement stmt = c.prepareStatement(DELETE_SQL);
        stmt.setInt(1, usuario.getId());
        
         int rowsAffect = stmt.executeUpdate();
         
            if (rowsAffect > 0) {
                sucesso = true;
            }
         
        stmt.close();
        c.close();
        
        
    } catch(SQLException e){
        e.printStackTrace();
    }
        
        return sucesso;
        
    }
}

    

