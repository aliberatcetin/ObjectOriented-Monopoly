
//jail class represents the area that sends the player to jail.
public class Jail extends UnSalable{
	public Jail(int position,String name,String color) {
		super(position,name,color);
	}

	//sends players to the jail by setting their position to 10.
	@Override
	public void event(Player player) {
		// TODO Auto-generated method stub
		player.setCurrentPosition(10);
		player.setPrison(true);
		player.reduceBalance(2000);
	}

	@Override
	public void Speak(Player player) {
		System.out.print(player.getName()+" is go to Jail. Balance will be reduced $2000 for exit fee. ");
	}
}
