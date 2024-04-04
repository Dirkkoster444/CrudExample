package nl.delpninity.gameshop.persistence.factories;
import nl.delpninity.gameshop.domain.Game;
import nl.delpninity.gameshop.domain.Gameshop;
import nl.delpninity.gameshop.persistence.DAO.GameDAO;
import nl.delpninity.gameshop.persistence.DAO.GameshopDAO;
import nl.delpninity.gameshop.persistence.DAO.GenericDAO;
import nl.delpninity.gameshop.persistence.interfaces.IGameDAO;
import nl.delpninity.gameshop.persistence.interfaces.IGameshopDAO;
import nl.delpninity.gameshop.persistence.util.HibernateSessionManager;
import org.hibernate.Session;
public class HibernateDAOFactory extends DAOFactory{
    protected Session getCurrentSession() {
        return (Session) HibernateSessionManager.getSessionFactory().openSession();
    }
    @Override
    public IGameDAO getGameDAO() {
        GenericDAO<Game, Integer> dao = null;
        try {
            dao = GameDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IGameDAO) dao;
    }
    @Override
    public IGameshopDAO getGameshopDAO() {
        GenericDAO<Gameshop, Integer> dao = null;
        try {
            dao = GameshopDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IGameshopDAO) dao;
    }
}