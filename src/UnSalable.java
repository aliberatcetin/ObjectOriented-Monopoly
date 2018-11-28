//unsalable class represents the unsaleable types of monopoly squares.
public class UnSalable extends Square{
	public UnSalable(int position,String name,String color) {
		super(position,name,color);
	}
	@Override
	public void Speak(Player player) {
		
	}

	//the unsaleable squares have events to implement to a player.
	public void event(Player player){
		
	}
}
