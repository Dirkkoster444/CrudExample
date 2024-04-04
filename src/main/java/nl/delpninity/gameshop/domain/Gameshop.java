package nl.delpninity.gameshop.domain;

import jakarta.persistence.*;
import nl.delpninity.gameshop.persistence.factories.DAOFactory;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Gameshop")
@Inheritance(strategy = InheritanceType.JOINED)
public class Gameshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "gameshopId")
    private Integer id;

   @OneToMany(mappedBy = "gameshop")
    private List<Game> games;

   public Gameshop(){
   }

    public void addGame(Game game) {
        if (games == null)
            games = new ArrayList<>();
        games.add(game);
        game.save();
    }

    public void deleteGame(Integer id){
        Game d = DAOFactory.getFactory().getGameDAO().findById(id);
        DAOFactory.getFactory().getGameDAO().delete(d);
    }

    public void editGame(Integer id, Game game){
       Game foundGame = DAOFactory.getFactory().getGameDAO().findById(id);

       foundGame.setName(game.getName());
       foundGame.setPrice(game.getPrice());
       foundGame.setDescription(game.getDescription());

       DAOFactory.getFactory().getGameDAO().update(foundGame);
    }

    public ArrayList<Game> getAllGames() {
        return DAOFactory.getFactory().getGameDAO().findAll();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
