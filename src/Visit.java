

public class Visit extends UnSalable{
	public Visit(int position,String name,String color) {
		super(position,name,color);
	}
	@Override
	public void Speak(Player player) {
		if(player.isPrison()) {
			System.out.println(player.getName() + " is in prison now ");
		}else {
			System.out.println(player.getName() + " is visiting someone ");
		}
	}
	@Override
	public void event(Player player) {
		// TODO Auto-generated method stub
		return;
	}
}
