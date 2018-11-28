import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//represent chance
public class Chance extends UnSalable{
	
	 
	
	
	private List<Card> Cards = new ArrayList<Card>();
	
	
	
	public Chance(int position,String name,String color) {
		super(position,name,color);
		for(int i=0;i<6;i++) {
			Cards.add(new Card(i+1));
		}
	}
	@Override
	public void Speak(Player player) {
		System.out.print(player.getName() +" comes "+getName()+"("+getPosition()+"). ");
	}
	@Override
	public void event(Player player) {
		int randomCard=(int) (Math.random() * 6 );
		Card c = Cards.get(randomCard);
		try {
			transaction(c,player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void transaction(Card card,Player player)throws Exception{
        
        // Creating class object from the object using 
        // getclass method 
        Class cls = card.getClass(); 
        String methodName = card.methodType();
        Method methodcall1 = cls.getDeclaredMethod(methodName,Player.class); 
        
        methodcall1.invoke(card,player);
	}
}
