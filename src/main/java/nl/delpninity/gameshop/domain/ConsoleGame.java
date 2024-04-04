package nl.delpninity.gameshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ConsoleGame extends Game{

    @Column(name = "requiredAge", nullable = true)
    private int requiredAge;

    @Column(name = "region", nullable = true)
    private String region;

    @Column(name = "language", nullable = true)
    private String language;


    public ConsoleGame(Integer id, String name, int price, String description, int requiredAge, String language, String region) {
        super(name, price, description);
        this.requiredAge = requiredAge;
        this.language = language;
        this.region = region;
    }

    public ConsoleGame() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRequiredAge() {
        return requiredAge;
    }

    public void setRequiredAge(int requiredAge) {
        this.requiredAge = requiredAge;
    }
}
