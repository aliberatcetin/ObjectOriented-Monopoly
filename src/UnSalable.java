
public abstract class UnSalable extends Square{
	public UnSalable(int position,String name,String color) {
		super(position,name,color);
	}
	@Override
	public void Speak(Player player) {
		
	}
	
	public abstract void event(Player player);
}
