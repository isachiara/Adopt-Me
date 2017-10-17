package Connection;

import Model.Perfil;


public interface PerfilDAO {
    public void save (Perfil entity);
    public Perfil retornarDado (int id);
    public void delete (int id);
    public boolean search(String login, String senha);
    public void updateTable(Perfil entity, int id);
    public int getID(String email);
}
