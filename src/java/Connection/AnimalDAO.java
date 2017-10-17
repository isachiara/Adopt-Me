/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Model.Animal;
import java.util.ArrayList;

/**
 *
 * @author isabella
 */
public interface AnimalDAO {
    public void save(Animal entity, int fk);
     public  ArrayList<Animal> listPerfil(int id);
    public void delete(int id);
}
