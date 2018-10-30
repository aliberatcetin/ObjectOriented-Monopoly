
public class Tax extends UnSalable{

	
	private int Tax;
	public Tax(int position,String name,String color,int tax) {
		super(position,name,color);
		this.Tax=tax;
	}
	
	@Override
	public void Speak(Player player) {
		System.out.print(player.getName()+"moved to"+getName());
		System.out.println(player.getName() +"will pay " + this.Tax+ "to the bank" );
	}
	public Tax(int position,String name,String color) {
		super(position,name,color);
	}
}
