
//represents fund.
public class Fund extends UnSalable{
	public Fund(int position,String name,String color) {
		super(position,name,color);
	}
	
	@Override
	public void Speak(Player player) {
		System.out.println(player.getName() +" comes"+getName()+".");
	}

	@Override
	public void event(Player player) {
		
		// TODO Auto-generated method stub
		
	}
	
	
}

