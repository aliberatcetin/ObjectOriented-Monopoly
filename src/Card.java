import java.util.ArrayList;

public class Card {
	
	int cardType;
	cardType cm;
	public Card(int cardType) {
		this.cardType=cardType;
	}
	
	public String methodType() {
		return cm.getLeg(cardType);
	}
	
	public void one(Player player) {
		System.out.print(player.getName() +" will pay 150$ penalty due to overspeed ");
		player.reduceBalance(150);
	}
	public void two(Player player) {
		System.out.print(player.getName()+ " goes to the jail. Balance will be reduced by 2000$ ");
		player.setPrison(true);
		player.setCurrentPosition(10);
		player.reduceBalance(2000);
	}
	public void three(Player player) {
		System.out.print(player.getName() +" will pay 200$ to the hospital ");
		player.reduceBalance(200);
	}
	public void four(Player player) {
		System.out.print(player.getName()+"'s birthday, will receive 50$ from every rival " );
		ArrayList<Player> tempPlayers = new ArrayList<Player>(Game.getPlayers());
		for(int i=0;i<tempPlayers.size();i++) {
			if( !player.getName().equals(tempPlayers.get(i).getName()) )
			tempPlayers.get(i).reduceBalance(50);
		}
		player.addBalance( (tempPlayers.size()-1) * 50 );
	}
	public void five(Player player) {
		System.out.print(player.getName() + " played gambling, will pay 70$ to every rival " );
		ArrayList<Player> tempPlayers = new ArrayList<Player>(Game.getPlayers());
		for(int i=0;i<tempPlayers.size();i++) {
			if( !player.getName().equals(tempPlayers.get(i).getName()) )
			tempPlayers.get(i).addBalance(70);
		}
		player.reduceBalance( (tempPlayers.size()-1) * 70 );
	}
	public void six(Player player) {
		System.out.print(player.getName() + " goes to the start point by chance " );
		player.setCurrentPosition(0);
		player.addBalance(2000);
	}
}
