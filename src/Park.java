
public class Park extends UnSalable{
	public Park(int position,String name,String color) {
		super(position,name,color);
	}
	@Override
	public void Speak(Player player){
		System.out.println(player.getName() + " moved park.");
	}
	@Override
	public void event(Player player) {
		// TODO Auto-generated method stub
		return;
	}
	
}
