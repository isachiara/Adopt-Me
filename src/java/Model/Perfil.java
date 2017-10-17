/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author isabella
 */
public class Perfil {
    
    private int Id;
    private String Nome;
    private String Sobrenome;
    private String Date;
    private String Genero;
    private String Telefone;
    private String Celular;
    private String Email;
    private String senha;
    
      
        public int getId (){
            return this.Id;
        }
        
        public void setID(int id){
            this.Id = id;
        }
       
       public String getEmail(){
            return this.Email;
        }
       
        public void setEmail (String email){
            this.Email = email;
        }
       
       public String getSenha (){
           return this.senha;
       }
       
       public void setSenha (String senha){
           this.senha = senha;
       }
    
        public String getNome (){
            return this.Nome;
        }

        public String getSobrenome(){
            return this.Sobrenome;
        }

        public String getDate (){
            return this.Date;
        }

        public String getGenero (){
            return this.Genero;
        }

        public String getTelefone (){
            return this.Telefone;
        }

        public String getCelular(){
            return this.Celular;
        }

        public void setNome(String nome){
            this.Nome = nome;
        }

        public void setSobrenome (String sobrenome){
            this.Sobrenome = sobrenome;
        }

        public void setDate (String date){
            this.Date = date;
        }

        public void setGenero (String genero){
            this.Genero = genero;
        }

        public void setTelefone (String telefone){
            this.Telefone = telefone;
        }

        public void setCelular (String celular){
            this.Celular = celular;
        }
}
