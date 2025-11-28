package com.propertopia.model;

public class Field {
    private String name;
    private int price;
    private double multiplicator;
    private int houses;
    private int rent;
    private int housePrice;
    private Player owner;
    private String color;

    public Field(String name, int price, int multiplicator, int rent, int housePrice, int color) {
        this.name = name;
        this.price = price;
        this.multiplicator = multiplicator;
        this.houses = 0;
        this.rent = rent;
        this.housePrice = housePrice;
        this.color = color;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public Player getOwner() { return owner; }
    public void setOwner(Player owner) { this.owner = owner; }
    public int getRent() { return this.rent + (this.houses * this.multiplicator); }
    public void addHouse(Player owner) {
        if(this.owner != owner){
            return;
        }
        if(houses < 5){
            this.houses += 1;
        }
    }
    public void deleteHouse(Player owner) {
        if(this.owner != owner){
            return;
        }
        if(houses > 0){
            this.houses -= 1;
        }
    }
    public void getHousePrice() { return this.housePrice; }
}
