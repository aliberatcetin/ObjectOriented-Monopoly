import java.util.ArrayList;


public class Player {
    private String name; //Player's name
    private int balance = 50000; //balance default value
    private int currentPosition = 0; //players current position on the map
    private boolean isPrison = false; //keeps the player's jail sutiation
    private ArrayList<Property> propertys = new ArrayList<Property>(); //Keeps lands owned by players


    public Player(String name) {
        this.name = name;
    }

    // increase players balance
    public void addBalance(int amount) {
        balance += amount;
    }

    // decrease players balance
    public void reduceBalance(int amount) {
        balance -= amount;
    }

    // add the new land
    public void addLand(Property newLand) {
        propertys.add(newLand);
    }

    //remove owned land
    public void removeLand(Property land) {
        propertys.remove(land);
    }

    //move the player next position



    //getter and setter methods

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Property> getLandCards() {
        return propertys;
    }

    public boolean isPrison() {
        return isPrison;
    }

    public void setPrison(boolean prison) {
        isPrison = prison;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public ArrayList<Property> getPropertys() {
        return propertys;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setPropertys(ArrayList<Property> propertys) {
        this.propertys = propertys;
    }
}
