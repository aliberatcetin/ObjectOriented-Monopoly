import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println(45%41);
         Scanner scan =new Scanner(System.in);

        System.out.println("Oyuna hoşgeldin paşam adın nedir?");
        String name=scan.next();

        System.out.println("kaç kişi oynucan paşam");
        int numberofPlayer=scan.nextInt();
        DefaultMap dm = new DefaultMap();
        Game game=new Game(name,numberofPlayer,dm);

        game.run(5);
    }

}
