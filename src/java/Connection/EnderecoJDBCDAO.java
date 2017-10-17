/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoJDBCDAO implements EnderecoDAO {
Connection con = null;
    @Override
    public void save(Endereco entity) {
         
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "INSERT INTO endereco(CEP, cidade, estado, bairro) values (?, ?, ?, ?)";
                        
 			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			
			pst.setString(1, entity.getCep());
			pst.setString(2, entity.getCidade());
			pst.setString(3, entity.getEstado());
			pst.setString(4, entity.getBairro());
			
			pst.executeUpdate();
                        
                        
		} catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EnderecoJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
   
    @Override
    public void delete(int id){
            try {
                con = ConnectionFactory.getConnection();
                String insert_sql = "DELETE FROM ENDERECO WHERE idEndereco = ?";
                PreparedStatement pst;
                pst = con.prepareStatement(insert_sql);
                
                pst.setInt(1, id);
                
                pst.executeUpdate();
                pst.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException (ex);
            }
    }

    @Override
   public void updateTable(Endereco entity, int id) {

            try {
                con = ConnectionFactory.getConnection();
                PreparedStatement pst;                                                
                String insert_cep = "UPDATE endereco SET CEP = ? WHERE idEndereco = ?";
                String insert_cidade = "UPDATE endereco SET CIDADE = ? WHERE idEndereco = ?";
                String insert_estado = "UPDATE endereco SET ESTADO = ? WHERE idEndereco = ?";
                String insert_bairro = "UPDATE endereco SET BAIRRO = ? WHERE idEndereco = ?";
 
                        if(entity.getCep().equals("") == false){
                            pst = con.prepareStatement(insert_cep);
                            pst.setString(1, entity.getCep());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                          
                        }
                        if(entity.getCidade().equals("") == false){
                            pst = con.prepareStatement(insert_cidade);
                            pst.setString(1, entity.getCidade());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                            
                        }
                        if(entity.getEstado().equals("") == false){
                            pst = con.prepareStatement(insert_estado);
                            pst.setString(1, entity.getEstado());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                           
                        }
                        if(entity.getBairro().equals("") == false){
                            pst = con.prepareStatement(insert_bairro);
                            pst.setString(1, entity.getBairro());
                            pst.setInt(2, id);
                            pst.executeUpdate();
                            pst.close();
                        }
                      
                        
            } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException (ex);
            }
			
    }

    @Override
  public void defineFK(int id) {
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "UPDATE perfil SET IDendereco = ? WHERE idPerfil = ?";
                        
 			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			
			pst.setInt(1, id);
                        pst.setInt(2, id);
			
			pst.executeUpdate();
                        pst.close();
                        
        } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException (ex);
        }
			
    }
	
    @Override
        public Endereco retornarDado (int id){
            try {
                Endereco endereco = new Endereco();
                con = ConnectionFactory.getConnection();
                String insert_sql = "SELECT CEP, CIDADE, ESTADO, BAIRRO FROM ENDERECO WHERE idEndereco = ?";
 		PreparedStatement pst;
                ResultSet rs;
                
                pst = con.prepareStatement(insert_sql);
                pst.setInt(1, id);
                        
                        rs = pst.executeQuery();
                        
                        if(rs.next()){
                            endereco.setCep(rs.getString("CEP"));
                            endereco.setCidade(rs.getString("cidade"));
                            endereco.setEstado(rs.getString("estado"));
                            endereco.setBairro(rs.getString("bairro"));                            
                        } 
                        
                        rs.close(); 
                        pst.close();
                        return endereco;
                        
            }        catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PerfilJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
			
                           
             return null;
    }
    
}
