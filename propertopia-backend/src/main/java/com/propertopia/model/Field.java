public class Field {
    private String name;
    private int price;
    private Player owner;

    public Field(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public Player getOwner() { return owner; }

    public void setOwner(Player owner) { this.owner = owner; }
}