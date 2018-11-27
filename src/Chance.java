
//represent chance
public class Chance extends UnSalable{
	public Chance(int position,String name,String color) {
		super(position,name,color);
	}
	@Override
	public void Speak(Player player) {
		System.out.print(player.getName() +" comes "+getName());
	}
	@Override
	public void event(Player player) {
		// TODO Auto-generated method stub
		
	}
}
