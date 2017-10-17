/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Model.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class AnimalJDBCDAO implements AnimalDAO{
Connection con = null;
    @Override
    public void save(Animal entity, int fk) {
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "INSERT INTO animal(NOMEANIMAL , tipo, idade, caract, tratamento, IDdono) values (?, ?, ?, ?, ?, ?)";
 			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			
			pst.setString(1, entity.getNome());
			pst.setString(2, entity.getTipo());
			pst.setString(3, entity.getIdade());
			pst.setString(4, entity.getCaract());
                        pst.setString(5, entity.getTratamento());
                        pst.setInt(6, fk);
			
                        pst.executeUpdate();
                        pst.close();
                        
                        
                        
                } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(PerfilJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new RuntimeException (ex);
                     }
    }
    
    @Override
    public  ArrayList<Animal> listPerfil(int id){
	try {
            con = ConnectionFactory.getConnection();
            ArrayList<Animal> animais = new ArrayList<Animal>();
            
            String select_sql = "SELECT NOMEANIMAL, TIPO, IDADE, CARACT, TRATAMENTO FROM ANIMAL WHERE IDdono = ?";
            PreparedStatement pst;

            pst = con.prepareStatement(select_sql);
            
            ResultSet rs;
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Animal animal = new Animal();
                    animal.setNome(rs.getString("nomeanimal"));
                    animal.setTipo(rs.getString("tipo"));
                    animal.setIdade(rs.getString("idade"));
                    animal.setCaract(rs.getString("caract"));
                    animal.setTratamento(rs.getString("tratamento"));
                    
                    animais.add(animal);
                }
            }
            
            rs.close();
            
            return animais;
	} catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(AnimalJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
        return null;
    }

    @Override
    public void delete(int id) {
        try {
                con = ConnectionFactory.getConnection();
                String insert_sql = "DELETE FROM ANIMAL WHERE IDdono = ?";
                PreparedStatement pst;
                pst = con.prepareStatement(insert_sql);
                
                pst.setInt(1, id);
                
                pst.executeUpdate();
                pst.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException (ex);
            }
        
    }
    
    public void delete(String nome, int id) {
        try {
                con = ConnectionFactory.getConnection();
                String insert_sql = "DELETE FROM ANIMAL WHERE IDdono = ? AND nomeAnimal = ?";
                PreparedStatement pst;
                pst = con.prepareStatement(insert_sql);
                
                pst.setInt(1, id);
                pst.setString(2, nome);
                
                pst.executeUpdate();
                pst.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException (ex);
            }
        
    }
    
       public ArrayList<String> search(int id){
            try {
               con = ConnectionFactory.getConnection();
               
               ArrayList<String> animais = new ArrayList<String>();
               
               String insert_sql = "SELECT NOMEANIMAL FROM animal WHERE IDdono = ?";
               PreparedStatement pst = con.prepareStatement(insert_sql);
               ResultSet rs;
                        
                        pst.setInt(1, id);
                     
                        rs = pst.executeQuery();
                        
                        if(rs != null){
                            while(rs.next()){
                                String animal;
                                animal = rs.getString("nomeAnimal");
                                animais.add(animal);
                                
                            }
                        }
                        
                        return animais;
            } catch (ClassNotFoundException | SQLException ex) {
                     throw new RuntimeException (ex);
            }

			
    }
                
    public ArrayList<Animal> list(String tipo) {
	try {
            con = ConnectionFactory.getConnection();
            ArrayList<Animal> animais = new ArrayList<Animal>();
            
            String select_sql = "SELECT NOMEANIMAL, TIPO, IDADE, CARACT, TRATAMENTO, LOGIN FROM (ANIMAL,PERFIL) WHERE IDPerfil = IDdono AND TIPO = ?;";
            PreparedStatement pst = con.prepareStatement(select_sql);
            ResultSet rs;
            
            pst.setString(1, tipo);
            
            rs = pst.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Animal animal = new Animal();
                    animal.setNome(rs.getString("nomeanimal"));
                    animal.setTipo(rs.getString("tipo"));
                    animal.setIdade(rs.getString("idade"));
                    animal.setCaract(rs.getString("caract"));
                    animal.setTratamento(rs.getString("tratamento"));
                    animal.setDono(rs.getString("login"));
                    
                    animais.add(animal);
                }
            }
            
            rs.close();
            
            return animais;
	} catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(AnimalJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
        return null; 
    }
                
}
    


