
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
         Scanner scan =new Scanner(System.in);

        System.out.println("Oyuna hoşgeldin paşam adın nedir?");
        String name=scan.next();

<<<<<<< HEAD
        System.out.println("kaç kişi oynucan paşam");
=======
        System.out.println("kaç kişi oynucan paşam(2-6)");
>>>>>>> b1fa9f27fed36941f620c7a15f85875b3697cd57
        int numberofPlayer=scan.nextInt();
        //Map board = new Map();
        Game game=new Game(name,numberofPlayer);
        
<<<<<<< HEAD
        game.run(5);
=======
        game.run(10);
>>>>>>> b1fa9f27fed36941f620c7a15f85875b3697cd57
    }

}
