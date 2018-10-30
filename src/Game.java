
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String playerName;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Scanner scan =new Scanner(System.in);
    //DefaultMap md = new DefaultMap();
 
    private Map board = new Map();
    

    public Game(String playerName, int numOfPlayer) {
        createComputer(numOfPlayer);
        players.add(createPlayer(playerName));
        
    }


    private Player createPlayer(String name) {
        playerName=name;
        return new Player(name);
    }

    private void createComputer(int numberOfPlayer) {
        String[] names = {"Frodo", "Gandalf", "Gollum", "Sauron", "Saruman"};


        for (int i = 0; i < numberOfPlayer-1; i++) {
            players.add(new Player(names[i]));
        }

    }

    private int[] rollDices(){
        return new int[] {(int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1)};
    }

    private void move(Player player ,int diceNumber) {
        int prevPosition = player.getCurrentPosition(); //keep previous position
        player.setCurrentPosition((player.getCurrentPosition() +diceNumber) % 40);  //add the dice curren position
        if (player.getCurrentPosition() < prevPosition) player.addBalance(2000); //if player pass the start point earn tour money
        if (player.getCurrentPosition() == 30) { //if player move to jail zone
            player.setPrison(true);
            player.setCurrentPosition(10);
        }

        SquareEvent(player);
    }

    private void SquareEvent(Player player){
    	int position=player.getCurrentPosition();
    	Square tempSquare = board.getSquare(position);
        if(tempSquare instanceof Purchasable){  // karenın satın alınabilir olup olmadığına bakıyoruz
        	if ( !(((Purchasable) tempSquare).isSold() ) ){ //daha önce satılıp satılmadığını kontrol ediyoruz
                buySaleable(player,(Purchasable)tempSquare);
            }else{
                doPayment(player,(Purchasable)tempSquare); //daha önce alınmışsa kira ödemesi yapıyoruz
            }
        }
    }

    //teleport user when take luck cards
    private void teleport(Player player,int position) {
        player.setCurrentPosition(position);
    }

    private void decidePlayerOrder(){
        int[] dices;
        int maxDice=0;
        System.out.print("Let's play! These are dice of other players:  ");
        for (int i = 0; i <players.size()-1 ; i++) {
            dices=rollDices();
            System.out.print(players.get(i).getName()+":"+dices[0]+","+dices[1]+"  ");
            if(dices[0]+dices[1]>maxDice){
                players.add(0,players.get(i));
                players.remove(i+1);
                maxDice=dices[0]+dices[1];
            }
        }
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

    private void RoundLastPlayer(){
        int dices[];
        int totalDice;
        for (int i = 0; i <players.size()-1 ; i++) {
            dices=rollDices();
            totalDice=dices[0]+dices[1];
            System.out.print(players.get(i).getName()+" is roll dice :"+dices[0]+","+dices[1]+". Move "+totalDice+" blocks.");
            move(players.get(i),totalDice);
            System.out.println("He is in "+players.get(i).getCurrentPosition()+" now.");
        }

        System.out.println("Press any button to roll a dice");
        scan.next();
        dices=rollDices();
        totalDice=dices[0]+dices[1];
        System.out.print(players.get(players.size()-1).getName()+" is roll dice :"+dices[0]+","+dices[1]+". Move "+totalDice+" blocks.");
        move(players.get(players.size()-1),totalDice);
        System.out.println("He is in "+players.get(players.size()-1).getCurrentPosition()+" now.");

    }

    private void RoundFirstPlayer(){
        int dices[];
        int totalDice;

        System.out.println("Press any button to roll a dice");
        scan.next();
        dices=rollDices();
        totalDice=dices[0]+dices[1];
        System.out.print(players.get(0).getName()+" is roll dice :"+dices[0]+","+dices[1]+". Move "+totalDice+" blocks.");
        move(players.get(0),totalDice);
        System.out.println("He is in "+players.get(0).getCurrentPosition()+" now.");

        for (int i = 1; i <players.size() ; i++) {
            dices=rollDices();
            totalDice=dices[0]+dices[1];
            System.out.print(players.get(i).getName()+" is roll dice :"+dices[0]+","+dices[1]+". Move "+totalDice+" blocks.");
            move(players.get(i),totalDice);
            System.out.println("He is in "+players.get(i).getCurrentPosition()+" now.");
        }



    }

    private void buySaleable(Player player,Purchasable saleable){
        if(player.getBalance()>=saleable.getPurchasePrice()){
            if(player.getName().equals(playerName)){
                System.out.println("Dou u want to "+saleable.getName()+"(y/n)");
                if(scan.next().equals("y")){
                    player.addProperty(saleable);
                    saleable.setOwner(player);
                    player.reduceBalance(saleable.getPurchasePrice());
                }
            }else{
                player.addProperty(saleable);
                saleable.setOwner(player);
                player.reduceBalance(saleable.getPurchasePrice());
                System.out.println(player.getName()+" is purchase "+saleable.getName());
                System.out.println(player.getPropertys().get(0).getName());
            }

        }else{
            System.out.println(player.getName()+"cant buy "+saleable.getName()+" Its expensive.");
        }

    }

    private void doPayment(Player player,Purchasable saleable){
        player.reduceBalance(saleable.getRentPrice());
        saleable.getOwner().addBalance(saleable.getRentPrice());
    }

    public void run(int roundNumber){
        boolean checkPlayer=false;
        int currentRound=0;
        if(players.size()>1) decidePlayerOrder();
        if(players.get(0).getName().equals(playerName)) checkPlayer=true;
        while(currentRound<=roundNumber){
            if(checkPlayer){
                RoundFirstPlayer();
            }
            else{
                RoundLastPlayer();
            }

            currentRound++;
            System.out.println("-------------------------------");
        }

    }

}
