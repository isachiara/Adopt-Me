package Connection;

import Model.Endereco;
import Model.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerfilJDBCDAO implements PerfilDAO {
        Connection con = null;
            
    @Override
    public void save(Perfil entity) {
        
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "INSERT INTO perfil(login, senha, nomePerfil, sobrenome, nascimento, sexo, telefone, celular) values (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst;
                        ResultSet rs;
                        
                        pst = con.prepareStatement(insert_sql);
			
                        pst.setString(1, entity.getEmail());
                        pst.setString(2, entity.getSenha());
			pst.setString(3, entity.getNome());
			pst.setString(4, entity.getSobrenome());
			pst.setString(5, entity.getDate());
			pst.setString(6, entity.getGenero());
			pst.setString(7, entity.getTelefone());
			pst.setString(8, entity.getCelular());
                        
			pst.executeUpdate();
                        pst.close();
                        
                                            
   
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada.", e);
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
	}
    
    
    @Override
    public Perfil retornarDado (int id){
            try {
                Perfil usuario = new Perfil();
                Connection con = ConnectionFactory.getConnection();
                String insert_sql = "SELECT nomePerfil, sobrenome, nascimento, sexo, telefone, celular FROM perfil where idPerfil = ?";
 		PreparedStatement pst;
                ResultSet rs;
                
                pst = con.prepareStatement(insert_sql);
                pst.setInt(1, id);
                        
                        rs = pst.executeQuery();
                        
                        if(rs.next()){
                            usuario.setNome(rs.getString("nomePerfil"));
                            usuario.setSobrenome(rs.getString("sobrenome"));
                            usuario.setDate(rs.getString("nascimento"));
                            usuario.setGenero(rs.getString("sexo"));
                            usuario.setTelefone(rs.getString("telefone"));
                            usuario.setCelular(rs.getString("celular"));  
                        } 
                        
                        rs.close(); 
                        pst.close();
                        return usuario;
                        
            }        catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PerfilJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
			
                           
             return null;
                        
    }
    
        @Override
     public boolean search(String login, String senha){
        boolean autenticado = false;
            try {
                con = ConnectionFactory.getConnection();
                String insert_sql = "SELECT login, senha FROM perfil where login = ? and senha = ?";
 			PreparedStatement pst;
                        ResultSet rs;
                        
			pst = con.prepareStatement(insert_sql);
                        
                        pst.setString(1, login);
                        pst.setString(2, senha);
                        rs = pst.executeQuery();
                        
                        if(rs.next()){
                            String loginBanco = rs.getString("login");
                            String senhaBanco = rs.getString("senha");
                            autenticado = true;
                        }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PerfilJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        
                  
             return autenticado;
			
    }
    
        @Override
    public void delete(int id){
            try {
                con = ConnectionFactory.getConnection();
                String insert_sql = "DELETE FROM PERFIL WHERE idPerfil = ?";
                PreparedStatement pst;
                pst = con.prepareStatement(insert_sql);
                
                pst.setInt(1, id);
                
                pst.executeUpdate();
                pst.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PerfilJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @Override
     public void updateTable(Perfil entity, int id) {
            try {
                Connection con = ConnectionFactory.getConnection();
                String insert_nome = "UPDATE perfil SET nomePerfil = ? WHERE idPerfil = ?";
                String insert_sobrenome = "UPDATE perfil SET sobrenome = ? WHERE idPerfil = ?";
                String insert_nascimento = "UPDATE perfil SET nascimento = ? WHERE idPerfil = ?";
                String insert_genero = "UPDATE perfil SET sexo = ? WHERE idPerfil = ?";
                String insert_telefone = "UPDATE perfil SET telefone = ? WHERE idPerfil = ?";
                String insert_celular = "UPDATE perfil SET celular = ? WHERE idPerfil = ?";
 
                PreparedStatement pst;
                                                
                       
                        if(entity.getNome().equals("") == false){
                            System.out.println(entity.getNome());
                            pst = con.prepareStatement(insert_nome);
                            pst.setString(1, entity.getNome());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                          
                        }
                        if(entity.getSobrenome().equals("") == false){
                            pst = con.prepareStatement(insert_sobrenome);
                            pst.setString(1, entity.getSobrenome());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                            
                        }
                        if(entity.getDate().equals("") == false){
                            pst = con.prepareStatement(insert_nascimento);
                            pst.setString(1, entity.getDate());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                           
                        }
                        if(entity.getGenero() != null){
                            pst = con.prepareStatement(insert_genero);
                            pst.setString(1, entity.getGenero());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                        }
                        if(entity.getTelefone().equals("") == false){
                            pst = con.prepareStatement(insert_telefone);
                            pst.setString(1, entity.getTelefone());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                           
                        }
                        if(entity.getCelular().equals("") == false){
                            pst = con.prepareStatement(insert_celular);
                            pst.setString(1, entity.getCelular());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                        }
                       
                        
                        
            } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException (ex);
            }
			
        
    }
    
    @Override
  public int getID (String email){
        int id = 0;
            try {
                Connection con = ConnectionFactory.getConnection();
                String insert_sql = "SELECT idPerfil FROM perfil WHERE login = ?";
                PreparedStatement pst;
                ResultSet rs;
                pst = con.prepareStatement(insert_sql);
                pst.setString(1, email);
                rs = pst.executeQuery();
                        
                        if(rs.next()){
                            id = rs.getInt("idPerfil");
                        }
            } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException (ex);
            }
                
        return id;
    }
      
}
   
