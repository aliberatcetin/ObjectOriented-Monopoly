
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
         Scanner scan =new Scanner(System.in);

        System.out.println("Welcome to Monopoly Game.What is your Name?");
        String name=scan.next();
        System.out.println("Enter number of Player(2-6):");
        Game game=new Game(name,scan.nextInt());
        System.out.println("Enter number of round:");
        game.run(scan.nextInt());
    }

}
