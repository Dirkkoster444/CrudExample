package nl.delpninity.gameshop.controller;

import com.opensymphony.xwork2.ActionSupport;
import nl.delpninity.gameshop.domain.Game;
import nl.delpninity.gameshop.domain.Gameshop;
import nl.delpninity.gameshop.domain.GameshopFacade;
import org.apache.struts2.action.SessionAware;
import java.util.Map;

public class AddGameAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private Game game;

    @Override
    public void withSession(Map<String, Object> session){
        this.session = session;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String addGame() {
    Gameshop g = GameshopFacade.getInstance().getGameshop();
    g.addGame(game);
    return "SUCCESS";
    }
}

