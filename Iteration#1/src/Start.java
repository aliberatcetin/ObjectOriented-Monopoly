//start class represents the start point.
public class Start extends UnSalable{
	public Start(int position,String name,String color) {
		super(position,name,color);
	}
	
	@Override
	public void Speak(Player player) {
		System.out.println(player.getName() +"passed start point" + "will receive 2000");
	}


	@Override
	public void event(Player player){
	}
	
}
