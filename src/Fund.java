import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//represents fund.
public class Fund extends UnSalable{
	public Fund(int position,String name,String color) {
		super(position,name,color);
		
	}
	
	@Override
	public void Speak(Player player) {
		System.out.print(player.getName() +" comes "+getName()+"("+getPosition() +"). ");
	}

	@Override
	public void event(Player player) {
        int randomMoney=(int) (Math.random() * 10 + 1);
        int money = randomMoney * 100;
        System.out.print(player.getName() +" will receive "+money+"$");
        player.addBalance(money);
	}
	
	
	
}

