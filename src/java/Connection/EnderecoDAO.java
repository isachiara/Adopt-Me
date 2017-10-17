/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Model.Endereco;

/**
 *
 * @author isabella
 */
public interface EnderecoDAO {
    public void save (Endereco entity); 
    public void delete(int id);
    public void updateTable (Endereco entity, int ID);
    public void defineFK (int id);
    public Endereco retornarDado (int id);
}
