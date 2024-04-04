package nl.delpninity.gameshop.controller;

import nl.delpninity.gameshop.domain.Gameshop;
import nl.delpninity.gameshop.domain.GameshopFacade;

public class DeleteGameAction{
    private int id;

    public String deleteGame(){
        Gameshop p = GameshopFacade.getInstance().getGameshop();
        p.deleteGame(id);
        return "SUCCESS";
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
