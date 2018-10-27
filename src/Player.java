import java.util.ArrayList;


public class Player {
    private String name; //Player's name
    private int balance = 50000; //balance default value
    private int currentPosition = 0; //players current position on the map
    private boolean isPrison = false; //keeps the player's jail sutiation
    private ArrayList<Arsa> arsas = new ArrayList<Arsa>(); //Keeps lands owned by players
    private ArrayList<Ulasim> ulasims = new ArrayList<Ulasim>();
    private ArrayList<Isletme> isletmes = new ArrayList<Isletme>();

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
    public void addArsa(Arsa newArsa) {
        arsas.add(newArsa);
    }
    public void addUlasim(Ulasim newUlasim) {
        ulasims.add(newUlasim);
    }
    public void addIsletme(Isletme newisletme) {
        isletmes.add(newisletme);
    }

    //remove owned land
    public void removeArsa(Arsa arsa) {
        arsas.remove(arsa);
    }
    public void removeUlasim(Ulasim ulasim) {
        ulasims.remove(ulasim);
    }
    public void removeIsletme(Isletme isletme) {
        isletmes.remove(isletme);
    }

    //move the player next position



    //getter and setter methods

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
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


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }


}
