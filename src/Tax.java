//tax class represents the tax areas that decreases the player's balance.
public class Tax extends UnSalable{
	int Tax;
	public Tax(int position,String name,String color,int tax) {
		super(position,name,color);
		this.Tax=tax;
	}

	@Override
	public void Speak(Player player) {
		System.out.print(player.getName()+" moved to "+getName()+"("+getPosition()+"). ");
		System.out.println(player.getName() +" will pay " + this.Tax+ " to the bank" );
	}

	//getters setters
	public int getTax() {
		return Tax;
	}
	public void setTax(int tax) {
		Tax = tax;
	}

	//reduces the balance of the player by tax rate;
	@Override
	public void event(Player player) {
		player.reduceBalance(Tax);
	}
	
	
}
