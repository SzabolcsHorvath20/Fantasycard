package com.company;

public class Card {

    private int power;
    private String name, faction, race, cardClass;

    public Card(int power, String name, String faction, String race, String cardClass) {
        this.power = power;
        this.name = name;
        this.faction = faction;
        this.race = race;
        this.cardClass = cardClass;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public String getFaction() {
        return faction;
    }

    public String getRace() {
        return race;
    }

    public String getCardClass() {
        return cardClass;
    }

    @Override
    public String toString() {
        return "Card{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", faction='" + faction + '\'' +
                ", race='" + race + '\'' +
                ", cardClass='" + cardClass + '\'' +
                '}';
    }
}
