package nl.delpninity.gameshop.persistence.factories;
import nl.delpninity.gameshop.persistence.interfaces.IGameDAO;
import nl.delpninity.gameshop.persistence.interfaces.IGameshopDAO;

public abstract class DAOFactory {
    private static DAOFactory factory;
    public static DAOFactory getFactory() {
        return factory;
    }
    public static void setFactory(Class<? extends DAOFactory> factory) {
        try {
            DAOFactory.factory = factory.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create DAOFactory: " + factory);
        }
    }
    public abstract IGameDAO getGameDAO();
    public abstract IGameshopDAO getGameshopDAO();
}