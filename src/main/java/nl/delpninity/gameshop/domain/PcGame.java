package nl.delpninity.gameshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PcGame extends Game{

    @Column(name = "ageRestriction", nullable = true)
    private int ageRestriction;

    @Column(name = "playerAmount", nullable = true)
    private int playerAmount;

    @Column(name = "recommendedSystemRequirements", nullable = true)
    private String recommendedSystemRequirements;

    public PcGame(Integer id, String name, int price, String description, int ageRestriction, String recommendedSystemRequirements, int playerAmount) {
        super(name, price, description);
        this.ageRestriction = ageRestriction;
        this.playerAmount = playerAmount;
        this.recommendedSystemRequirements = recommendedSystemRequirements;
    }

    public PcGame() {
        
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }


}
