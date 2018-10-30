import java.util.ArrayList;


public class Player {
    private String name; //Player's name
    private int balance = 50000; //balance default value
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
    
    public int howManyTransportation() {
    	int counter=0;
    	for(int i=0;i<propertys.size();i++) {
    		if( propertys.get(i) instanceof Transportation ) {
    			counter++;
    		}
    	}
    	return counter;
    }
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
}
