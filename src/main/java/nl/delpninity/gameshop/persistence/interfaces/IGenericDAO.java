package nl.delpninity.gameshop.persistence.interfaces;
import java.io.Serializable;
import java.util.*;

public interface IGenericDAO<T, ID extends Serializable>  {
    T save(T entity);
    T findById(ID id);

    ArrayList<T> findAll();

    T update(T entity);

    void delete(T entity);

}