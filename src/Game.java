
import java.util.ArrayList;
import java.util.Scanner;


//represents intention of calling the arrangerentprices method
public class Game {
    public enum intention{
        ADD,REMOVE;
    }


    private boolean checkTwice=false;   //for check dice twice
    private int counterTwice=0;         //for count dice twice
    private String playerName;          //for user's playername
    private ArrayList<Player> players = new ArrayList<Player>();  //for keep players
    private Scanner scan =new Scanner(System.in);   //define scanner
    private Map board = new Map();  //Create a default Map
    
    //consrtuctor for Game class
    public Game(String playerName, int numOfPlayer) {
        createComputer(numOfPlayer); //create a players for computers depend on given input num of player
        players.add(createPlayer(playerName)); //create player for user
        
    }

    //create aplayer with given playername
    private Player createPlayer(String name) {
        playerName=name;
        return new Player(name);
    }
    //for create computers
    private void createComputer(int numberOfPlayer) {
        String[] names = {"Frodo", "Gandalf", "Gollum", "Sauron", "Saruman"};//Computer Players's default names
        for (int i = 0; i < numberOfPlayer-1; i++) {
            players.add(new Player(names[i]));
        }

    }
    //use for roll a 2 dice and cehck the twice dice
    private int[] rollDices(){
        int dice1=(int) (Math.random() * 6 + 1);
        int dice2=(int) (Math.random() * 6 + 1);//roll a 2 dice randomly
        if(dice1==dice2){ //if 2 dices ara equal increase counterTwice and cehckTwice become true
            counterTwice++;
            checkTwice=true;
        }else{
            counterTwice=0;
            checkTwice=false;
        }
        return new int[] {dice1, dice2}; //return the dices
    }
    //move method for carry forward player depond on dice number
    private void move(Player player ,int diceNumber) {
        int prevPosition = player.getCurrentPosition(); //keep previous position
        player.setCurrentPosition((player.getCurrentPosition() +diceNumber) % 40);  //add the dice curren position
        if (player.getCurrentPosition() < prevPosition){
            System.out.print(player.getName()+"passed start point.Received 2000$");
            player.addBalance(2000); //if player pass the start point earn tour money
        }

        SquareEvent(player); // call square event for current square
    }

    //squareEvent for execute current square's event
    private void SquareEvent(Player player){
    	int position=player.getCurrentPosition();//get player's current position
    	Square tempSquare = board.getSquare(position); //get player's current Square
    	tempSquare.Speak(player); //The square is give us information
        if(tempSquare instanceof Purchasable){  // check the suare is saleanle or unsaleable
        	if ( !(((Purchasable) tempSquare).isSold()) ){ //Check the square is sold before
                buySaleable(player,(Purchasable)tempSquare);
            }else{
                doPayment(player,(Purchasable)tempSquare); //if square solded before do payment rentPrice
            }
        }else{
            ((UnSalable)tempSquare).event(player); //is square unSaleable we call the event method for this square
        }
    }

    //called every time a trade happens
    private void arrangePurchasableRents(Purchasable purchasable, intention intention) {
        double value;
        if(intention.ordinal()==0){
            value=2.0;
        }else{
            value=0.5;
        }
    	ArrayList<Purchasable> tempSquares = new ArrayList<Purchasable>(purchasable.getOwner().getPropertys());
    	
    	if( purchasable instanceof Property ) {
    		if( purchasable.getOwner().hasAllColors((Property)purchasable)  ) {
        		for(int i=0;i<tempSquares.size();i++) {
        			if( tempSquares.get(i).getColor().equals( purchasable.getColor() )  ) {
        				purchasable.getOwner().getPropertys().get(i).setRentPrice((int)(tempSquares.get(i).getRentPrice()*value));
        			}
        		}
        	}
    	}else if( purchasable instanceof Transportation ) {
    		int howMany=purchasable.getOwner().howManyTransportation();
    		for(int i=0;i<tempSquares.size();i++) {
    			if( tempSquares.get(i) instanceof Transportation ) {
    				purchasable.getOwner().getPropertys().get(i).setRentPrice(250*howMany);
    			}
    		}
    	}else {
    		if(purchasable.getOwner().hasAllFirm()) {
    			for(int i=0;i<tempSquares.size();i++) {
    				if( tempSquares.get(i) instanceof Firm ) {
    					purchasable.getOwner().getPropertys().get(i).setRentPrice( 100 );
    				}
    			}
    		}
    	}
    }
    
   //The method is decide play order.The players roll dices and the player which is rolled maximum take the first place.
    private void decidePlayerOrder(){
        int[] dices;
        int maxDice=0;
        //this part of players
        System.out.print("Let's play! These are dice of other players:  ");
        for (int i = 0; i <players.size()-1 ; i++) {
            dices=rollDices();
            System.out.print(players.get(i).getName()+":"+dices[0]+","+dices[1]+"  "); //print the players dices
            if(dices[0]+dices[1]>maxDice){ //find the maximum dice and took him first place
                players.add(0,players.get(i));
                players.remove(i+1);
                maxDice=dices[0]+dices[1];
            }
        }
        //this part for user
        System.out.println();
        System.out.println("Press any button to roll a dice");
        scan.next();
        dices=rollDices();
        System.out.println(players.get(players.size()-1).getName()+":"+dices[0]+","+dices[1]+"  ");

        if(dices[0]+dices[1]>maxDice){
            players.add(0,players.get(players.size()-1));
            players.remove(players.size()-1);
            maxDice=dices[0]+dices[1];
        }

        System.out.println(players.get(0).getName()+" will be begin!");
    }

    //This method for play one round
    private void playOneRound(){
        int dices[];
        int totalDice;
        for (int i = 0; i <players.size() ; i++) {
            do {
                if(players.get(i).getName().equals(playerName)){ // if the current player is a user program want the press any button for roll dices
                    System.out.println("Press any button to roll a dice");
                    scan.next();
                }
                if(counterTwice>=3){ //chechk twice dices for go to jail
                    System.out.print(players.get(i).getName()+" roll double dice three time.Goes to prison.");
                    players.get(i).setCurrentPosition(10);
                    counterTwice=0;
                    checkTwice=false;
                    break;
                }
                //rol dices and move the player
                dices=rollDices();
                totalDice=dices[0]+dices[1];
                System.out.print(players.get(i).getName()+" is roll dice :"+dices[0]+","+dices[1]+". Move "+totalDice+" blocks.");
                move(players.get(i),totalDice);
                System.out.println(players.get(i).getName()+"'s Balance: $"+players.get(i).getBalance());
                players.get(i).speak();
            }while (checkTwice); //if player roll twice dice play again
            System.out.println();
        }
    }

    //use for buy a Purchasable square
    private void buySaleable(Player player,Purchasable saleable){
        String choice="";
        if(player.getBalance()>=saleable.getPurchasePrice()){ // check player balance
            if(player.getName().equals(playerName)){//if players is user ask for process
                System.out.println("Dou u want to "+saleable.getName()+"("+saleable.getPurchasePrice()+"$)"+"(y/n)");
                 choice=scan.next();
            }
        if(!choice.equals("n")){ //check for player answer
            player.reduceBalance(saleable.getPurchasePrice()); //redu de player balance
            player.addProperty(saleable); //add the property to player's propertys
            saleable.setOwner(player); // set the property owner
            saleable.setSold(true); //SETSold become tru for Property
            System.out.print(player.getName()+" is purchase "+saleable.getName()+ "("+saleable.getPurchasePrice()+ "$)"+ ".");
            arrangePurchasableRents(saleable,intention.ADD); //set the propertys rent price
        }
        }else{
            System.out.println(player.getName()+"cant buy "+saleable.getName()+" Its expensive.");
        }

    }

    //use for sell a Property
    private void sellSaleable(Player player,Purchasable saleable){
        arrangePurchasableRents(saleable,intention.REMOVE); //set the property's rent price
        player.addBalance(saleable.getHypothecPrice()); //add the player's balance for property's heypotech price
        player.removeProperty(saleable); //remove the property from user's propertys
        saleable.setSold(false); //setSold become false for property
    }

    //use for payment Rent price
    private void doPayment(Player player,Purchasable saleable){
        player.reduceBalance(saleable.getRentPrice());//reduce the baalance of player which is do payment
        saleable.getOwner().addBalance(saleable.getRentPrice());//add the balance to property's owner
    }
    //use for check players balance
    private void checkBalances(){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getBalance()<0){ //if palyer's balance less than 0 sell the player's propertys
                hypoteseSaleables(players.get(i));
            }
        }
    }

    //use for hypotech propertys
    private void hypoteseSaleables(Player player){
        while(player.getBalance()<0){ //sell the propertys as long as balance equal or more than 0
            if(player.getPropertys().size()>0){//check player's propertys
                if(!player.getName().equals(playerName)){ //if player is computer sell the first propetys which is own
                    sellSaleable(player,player.getPropertys().get(0));
                }else{
                    System.out.println("which property you want to sell ?"); //if player is user ask for sell process
                    for (int i = 0; i <player.getPropertys().size() ; i++) {
                        System.out.println(i+1+"-"+player.getPropertys().get(i).getName()+"("+player.getPropertys().get(i).getHypothecPrice()+"$)");
                    }
                    sellSaleable(player,player.getPropertys().get(scan.nextInt()));
                }

            }else{ //if player has no property the player go bankrupt
                System.out.println(player.getName()+ " go bankrupt.");
                players.remove(player);
                break;
            }

        }
    }
    //use for find the winner
    private void findWinner(){
        Player winner=null;
        int maxBalance=0;
        for (int i= 0; i <players.size() ; i++) { //look for all user and decide winner player depend on player's balance
            if(players.get(i).getBalance()>maxBalance){
                maxBalance=players.get(i).getBalance();
                winner=players.get(i);
            }
        }
        System.out.println("The winner is "+winner.getName());
    }

    //run method call playOneRound method as long as the given round number is not end
    public void run(int roundNumber){
        int currentRound=0;
        if(players.size()>1) decidePlayerOrder(); // decide player order

        while(currentRound<=roundNumber){
            checkBalances();
            if(players.size()>1){
                playOneRound(); //call play one round
            }else{
                break;
            }

            currentRound++; //increase round counter
            System.out.println("-------------------------------");
        }
        findWinner(); //when the game is over find the Winner player
    }

}
