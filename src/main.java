
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
         Scanner scan =new Scanner(System.in);

        System.out.println("Welcome to Monopoly Game.What is your Name?"); //prompt the user name from user
        String name=scan.next();
        System.out.println("Enter number of Player(2-6):");//prompt the number of player from user
        Game game=new Game(name,scan.nextInt());
        System.out.println("Enter number of round:");//prompt the number of round from user
        game.run(scan.nextInt());
    }

}
