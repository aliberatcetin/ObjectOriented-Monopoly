
import java.io.IOError;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
         Scanner scan =new Scanner(System.in);
         int numOfPlayer;
        Game game = null;
        System.out.println("Welcome to Monopoly Game.What is your Name?"); //prompt the user name from user
        String name=scan.next();
        while(true){
            System.out.println("Enter number of Player(2-6):");//prompt the number of player from user

            try{
                numOfPlayer=scan.nextInt();
                if(numOfPlayer>0&&numOfPlayer<7){
                    game=new Game(name,numOfPlayer);
                    break;
                }else{
                    System.out.println("Your input is wrong. Please try again");
                   continue;
                }
            }catch (Exception e){
                System.out.println("Your input is wrong. Please try again");
                scan.next();
            }
        }

        while(true){
            System.out.println("Enter number of round:");//prompt the number of round from user
            try{
                game.run(scan.nextInt());
                break;
            }catch (Exception e){
                System.out.println("Your input is wrong. Please try again");
                scan.next();
            }
        }


    }

}
