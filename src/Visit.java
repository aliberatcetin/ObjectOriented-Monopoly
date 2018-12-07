
//visit class represents the visit.
public class Visit extends UnSalable{
	public Visit(int position,String name,String color) {
		super(position,name,color);
	}
	@Override
	public void Speak(Player player) {
		if(player.isPrison()) {
			System.out.print(player.getName() + " is in prison now"+ "("+ getPosition()+"). ");
		}else {
			System.out.print(player.getName() + " is visiting someone"+ "("+ getPosition()+"). ");
		}
	}
	@Override
	public void event(Player player) {
		// TODO Auto-generated method stub
		return;
	}
}
