
public class Purchasable extends Square {
	private int RentPrice;
	private int PurchasePrice;
	private int HypothecPrice;
	private Player owner;
	private boolean isSold;
	
	public boolean isSold() {
		return isSold;
	}
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	

	@Override
	public void Speak(Player player2) {
		if ( isSold ) {
			System.out.print(player2.getName()+" moved to " + getName() );
			System.out.println(player2.getName() + " will pay the rent to the " + owner);
		}else {
			System.out.print(player2.getName()+" moved to " + getName() );
		}
	}
	
	public Player getOwner() {
		return owner;
	}
	public Purchasable(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice) {
		super(position,name,color);
		this.RentPrice=rentprice;
		this.PurchasePrice=purchaseprice;
		this.HypothecPrice=hypothecprice;
		this.isSold=false;
	}
	

	
	public int getRentPrice() {
		return RentPrice;
	}
	public void setRentPrice(int rentPrice) {
		RentPrice = rentPrice;
	}
	public int getPurchasePrice() {
		return PurchasePrice;
	}
	public void setOwner(Player player) {
		this.owner=player;
	}
	public void setPurchasePrice(int purchasePrice) {
		PurchasePrice = purchasePrice;
	}
	public int getHypothecPrice() {
		return HypothecPrice;
	}
	public void setHypothecPrice(int hypothecPrice) {
		HypothecPrice = hypothecPrice;
	}	
}
