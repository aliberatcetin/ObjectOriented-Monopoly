
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
         Scanner scan =new Scanner(System.in);

        System.out.println("Oyuna hoşgeldin paşam adın nedir?");
        String name=scan.next();

        System.out.println("kaç kişi oynucan paşam");
        int numberofPlayer=scan.nextInt();
        //Map board = new Map();
        Game game=new Game(name,numberofPlayer);
        
        game.run(5);
    }

}
