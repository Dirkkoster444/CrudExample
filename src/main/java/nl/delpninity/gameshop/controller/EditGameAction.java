package nl.delpninity.gameshop.controller;

import nl.delpninity.gameshop.domain.Game;
import nl.delpninity.gameshop.domain.Gameshop;
import nl.delpninity.gameshop.domain.GameshopFacade;

public class EditGameAction {
    private Game game;
    private int id;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String editGame(){
    Gameshop shop = GameshopFacade.getInstance().getGameshop();
    shop.editGame(id, game);
    return "SUCCESS";
    }
}
