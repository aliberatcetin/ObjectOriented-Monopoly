import java.util.ArrayList;


public class Player {
    private String name; //Player's name
    private int balance = 50000; //balance default value
    private int currentPosition=0; //players current position on the map
    private boolean isPrison=false; //keeps the player's jail sutiation
    private ArrayList<Square> propertys=new ArrayList<Square>(); //Keeps lands owned by players

    
    public Player(String name){
        this.name=name;
    }

    // increase players balance
    public void addBalance(int amount){
        balance+=amount;
    }

    // decrease players balance
    public void reduceBalance(int amount){
        balance-=amount;
    }
    // add the new land
   public void addLand(Square newLand){
       propertys.add(newLand);
   }
    //remove owned land
   public void removeLand(Square land){
       propertys.remove(land);
   }

   //move the player next position
   public void move(int diceNumber){
        int prevPosition=currentPosition; //keep previous position
        currentPosition=(currentPosition+diceNumber)%40;   //add the dice curren position
        if(currentPosition<prevPosition) addBalance(2000); //if player pass the start point earn tour money
        if(currentPosition==30){ //if player move to jail zone
            setPrison(true);
            currentPosition=10;
        }


   }
    //teleport user when take luck cards
   public void teleport(int position){
        currentPosition=position;
   }

    //move the player next position


    //getter and setter methods

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Square> getLandCards() {
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


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
