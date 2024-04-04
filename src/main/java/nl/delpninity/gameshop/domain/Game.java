package nl.delpninity.gameshop.domain;

import jakarta.persistence.*;
import nl.delpninity.gameshop.persistence.factories.DAOFactory;

@Entity
public class Game{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "gameId")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "gameshopId")
    private Gameshop gameshop;
    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "price")
    private double price;

    @Column(name = "description")
    private String description;


    public Game() {
    }

    public Game(Integer id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Game(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", naam='" + name + '\'' +
                ", prijs=" + price +
                ", beschrijving='" + description + '\'' +
                '}';
    }


    public void save() {
        DAOFactory.getFactory().getGameDAO().save(this);
    }
}

