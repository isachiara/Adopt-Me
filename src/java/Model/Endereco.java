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
public class Endereco {
    
    public int id;
    public String cep;
    public String estado;
    public String cidade;
    public String bairro;
    
    public Endereco (){
       
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getCep (){
        return this.cep;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public String getCidade(){
        return this.cidade;
    }
    
    public String getBairro(){
        return this.bairro;
    }
    
    public void setCep (String cep){
        this.cep = cep;
    }
    
    public void setEstado (String estado){
        this.estado = estado;
    }
    
    public void setCidade (String cidade){
        this.cidade = cidade;
    }
    
    public void setBairro (String bairro){
        this.bairro = bairro;
    }
}

