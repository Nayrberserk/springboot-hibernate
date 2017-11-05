package pe.edu.tecsup.hibernate.helper;

import java.util.List;

import pe.edu.tecsup.hibernate.model.Curso;

public interface GenericDAO<T> {

    public List<T> list();

    public T get(Long t);
    

    public void save(T t);

    public void update(T t);

    public void delete(T t);



}
