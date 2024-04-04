package nl.delpninity.gameshop.domain;

import nl.delpninity.gameshop.persistence.factories.DAOFactory;

public class GameshopFacade {

    private static GameshopFacade instance;

    public static GameshopFacade getInstance() {
        if (instance == null)
            instance = new GameshopFacade();
        return instance;
    }

    public Gameshop getGameshop() {
        return DAOFactory.getFactory().getGameshopDAO().findById(1);
    }

}