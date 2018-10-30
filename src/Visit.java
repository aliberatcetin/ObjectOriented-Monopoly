

public class Visit extends UnSalable{
	public Visit(int position,String name,String color) {
		super(position,name,color);
	}

	
	@Override
	public void Speak(Player player) {
		if ( player.isPrison() ) {
			System.out.println(player.getName()+"went to jail");
		}
	}

}
