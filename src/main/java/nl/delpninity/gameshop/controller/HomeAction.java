package nl.delpninity.gameshop.controller;

import nl.delpninity.gameshop.domain.Game;
import nl.delpninity.gameshop.domain.Gameshop;
import nl.delpninity.gameshop.domain.GameshopFacade;

import java.util.ArrayList;
import java.util.Set;

public class HomeAction {
    private ArrayList<Game> games;

    public ArrayList<Game> getGames() {
        return games;
    }
    
    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public String home() {
    Gameshop shop = GameshopFacade.getInstance().getGameshop();
    games = shop.getAllGames();
    return "SUCCESS";
    }

}
