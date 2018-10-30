
public class Chance extends UnSalable{
	public Chance(int position,String name,String color) {
		super(position,name,color);
	}

	
	@Override
	public void Speak(Player player) {
		System.out.println(player.getName() +"comes"+getName());
	}
	

}
