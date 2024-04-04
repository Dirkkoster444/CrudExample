package nl.delpninity.gameshop.persistence.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import nl.delpninity.gameshop.persistence.interfaces.IGenericDAO;
import org.hibernate.Transaction;

public abstract class GenericDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

    private Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void setSession(Session s) {
        this.session = s;
    }

    public Session getSession() {
        if (session == null) {
            throw new IllegalStateException("Session has not been set on DAO before usage");
        }
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }



    public void load(T entity) {
        getSession().refresh(entity);
    }

    @Override
    public T update(T entity) {
        getSession().beginTransaction();
        getSession().merge(entity);
        getSession().getTransaction().commit();
        return entity;
    }



    @Override
    public T save(T entity) {
        Transaction transaction = getSession().beginTransaction();
        getSession().persist(entity);
        transaction.commit();
        return entity; // Retourneer het opgeslagen entiteit
    }

    /**
     * @see datalayer.interfaces.IGenericDAO#delete(java.lang.Object)
     */
    @Override
    public void delete(T entity) {
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    public void detach(T entity) {
        getSession().detach(entity);
    }

    /**
     * @see datalayer.interfaces.IGenericDAO#findById(java.io.Serializable)
     */

    public T findById(ID id) {
        T entity = getSession().find(getPersistentClass(), id);
        return entity;
    }

    /**
     * @see datalayer.interfaces.IGenericDAO#findByNaturalID(java.lang.Object)
     */
    public T findByNaturalID(Object naturalID) {
        return getSession().bySimpleNaturalId(getPersistentClass()).load(naturalID);
    }

    /**
     * @see datalayer.interfaces.IGenericDAO#findAll()
     */
    @Override
    public ArrayList<T> findAll() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(getPersistentClass());
        Root<T> root = criteria.from(getPersistentClass());
        criteria.select(root);
        return (ArrayList<T>) getSession().createQuery(criteria).getResultList();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

}