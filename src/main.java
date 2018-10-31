
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
         Scanner scan =new Scanner(System.in);

        System.out.println("Oyuna hoşgeldin paşam adın nedir?");
        String name=scan.next();
        System.out.println("kaç kişi oynucan paşam(2-6)");
        Game game=new Game(name,scan.nextInt());
        System.out.println("Kaç tur Oynucam Paşam");
        game.run(scan.nextInt());
    }

}
