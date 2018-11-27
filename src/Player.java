import java.sql.SQLOutput;
import java.util.ArrayList;

//Player class for representing a player in game
public class Player {
    private String name; //Player's name
    private int balance = 10000; //balance default value
    private int currentPosition=0; //players current position on the map
    private boolean isPrison=false; //keeps the player's jail sutiation
    private ArrayList<Purchasable> propertys=new ArrayList<Purchasable>(); //Keeps lands owned by players

    
    public Player(String name){
        this.name=name;
    }
    
    public void addProperty(Purchasable newPurchasable) {
    	propertys.add(newPurchasable);
    }
    public void removeProperty(Purchasable purchasable) {
        propertys.remove(purchasable);
    }

    // increase players balance
    public void addBalance(int amount){
        balance+=amount;
    }

    // decrease players balance
    public void reduceBalance(int amount){
        balance-=amount;
    }


    //find if the player has all neighbors of a color.
    public boolean hasAllColors(Property prop) {
    	int counter=0;
    	for(int i=0;i<propertys.size();i++) {
    		if( propertys.get(i).getColor().equals(prop.getColor()) ) {
    			counter++;
    		}
    	}
    	if(counter==prop.getTotalNeighbor()) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }

    //returns how many transportation firm of player
    public int howManyTransportation() {
    	int counter=0;
    	for(int i=0;i<propertys.size();i++) {
    		if( propertys.get(i) instanceof Transportation ) {
    			counter++;
    		}
    	}
    	return counter;
    }

    //does this player have all of the firms.
    public boolean hasAllFirm() {
    	int counter=0;
    	for(int i=0;i<propertys.size();i++) {
    		if( propertys.get(i) instanceof Firm ) {
    			counter++;
    		}
    	}
    	if(counter==2) {
    		return true;
    	}else {
    		return false;
    	}
    }
    




    //getter and setter methods

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Purchasable> getPropertys() {
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

    //speak method for printing player's propertys
    public void speak(){
        if(propertys.size()>0){
            System.out.println(name+"'s Propertys:");
            for (int i = 0; i <propertys.size() ; i++) {

                switch (propertys.get(i).getColor()){
                    case "RED":
                        System.out.print(Color.RED);
                        break;
                    case "ORANGE":
                        System.out.print(Color.ORANGE);
                        break;
                    case "BLUE":
                        System.out.print(Color.BLUE);
                        break;
                    case "GREEN":
                        System.out.print(Color.GREEN);
                        break;
                    case "PINK":
                        System.out.print(Color.PINK);
                        break;
                    case "SKYBLUE":
                        System.out.print(Color.SKYBLUE);
                        break;
                    case "BROWN":
                        System.out.print(Color.WHITE);
                        break;
                    case "TRANSPARENT":
                        System.out.print(Color.BLACK);
                        break;
                }


                System.out.println(i+1+"-"+propertys.get(i).getName()+"----"+propertys.get(i).getColor()+"----"+propertys.get(i).getRentPrice()+Color.RESET);
            }
        }
        System.out.println();
    }
}
