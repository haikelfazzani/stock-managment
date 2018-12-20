package dao;

import java.util.List;

public interface IDao<Object> {

    public boolean ajouter(Object o);
    public boolean modifier(String nom, Object o);
    public boolean supprimer(String nom);
    public Object getObject(String nom);
    public List<Object> getAll();
}
