
public class Jail extends UnSalable{
	public Jail(int position,String name,String color) {
		super(position,name,color);
	}

	@Override
	public void event(Player player) {
		// TODO Auto-generated method stub
		player.setCurrentPosition(10);
		player.setPrison(true);
	}
	
	
	
}
