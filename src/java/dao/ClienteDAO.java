
package dao;


import bancodedados.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.postgresql.Driver;
 


public class ClienteDAO {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // nome do seu banco
    private static final String USUARIO = "postgres"; // seu usuário
    private static final String SENHA = "1234";
    
    private static final String INSERT_SQL = "INSERT INTO clientes (nome, cpf, email, datadenascimento) VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
    private static final String SELECT_SQL = "SELECT * FROM clientes order by id_cliente";
    private static final String UPDATE_SQL = "UPDATE clientes SET nome = ?, cpf = ?, email = ?, datadenascimento = TO_DATE(?, 'YYYY-MM-DD') WHERE id_cliente = ?";
    private static final String DELETE_SQL = "delete from clientes WHERE id_cliente = ?";
    
    
    public static void main(String[] args){
        //BuscarUsuarios();
        //InserirUsuario();
        //AtualizarUsuario();
        //DeletarUsuario();
    }
    
    //CRUD
    //READ
    public static ArrayList BuscarClientes(){
        ArrayList<Cliente> clientes = new ArrayList();
        
        try {
    
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        
        Connection conectando = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        
        PreparedStatement stmt = conectando.prepareStatement(SELECT_SQL);
        
        ResultSet rs = stmt.executeQuery();
        
        
        while(rs.next()){
            int id = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String dataDeNascimento = rs.getString("datadenascimento");
            
            Cliente c = new Cliente();
            
            c.setId(id);
            c.setNome(nome);
            c.setCpf(cpf);
            c.setEmail(email);
            c.setDatadenascimento(dataDeNascimento);
            clientes.add(c);
        }
        
        stmt.close();
        conectando.close();
        
        
    } catch(SQLException e){
        e.printStackTrace();
    }
        
        return clientes;
    }
    
    //CREATE
    public static boolean InserirClientes(Cliente cliente){
        
        boolean sucesso = false;
        
        try {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection c = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        PreparedStatement stmt = c.prepareStatement(INSERT_SQL);
        
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getDatadenascimento());
        
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
    public static boolean AtualizarClientes(Cliente cliente){
        boolean sucesso = false;
        try {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        
        Connection c = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        
        PreparedStatement stmt = c.prepareStatement(UPDATE_SQL);
        
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getDatadenascimento());
        stmt.setInt(5, cliente.getId());
        
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
    public static boolean DeletarClientes(Cliente a){
        boolean sucesso = false;
        try {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        
        Connection c = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
        
        PreparedStatement stmt = c.prepareStatement(DELETE_SQL);
        stmt.setInt(1, a.getId());
        
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

    

