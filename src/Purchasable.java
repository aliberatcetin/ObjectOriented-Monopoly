//purchasable class represents the purchasable types of monopoly squares.
public class Purchasable extends Square {
	private int RentPrice;
	private int PurchasePrice;
	private int HypothecPrice;
	private Player owner;
	private boolean isSold;//does this property belongs a player or not
	private int totalNeighbor;//the max neighbor of a property. E.g. yellow properties have 3 neighbor at max.


	public int getTotalNeighbor() {
		return totalNeighbor;
	}
	public void setTotalNeighbor(int totalNeighbor) {
		this.totalNeighbor = totalNeighbor;
	}
	public boolean isSold() {
		return isSold;
	}
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	

	@Override
	public void Speak(Player player2) {
		if ( isSold ) {
			System.out.print(player2.getName()+" moved to " + getName() + "("+ getPosition()+"). " );
			System.out.print(player2.getName()+" will pay rent("+ RentPrice +"$)"+" to "  + owner.getName()+". ");
		}else {
			System.out.print(player2.getName()+" moved to " + getName()+"("+getPosition()+"). " );
		}
	}
	
	public Player getOwner() {
		return owner;
	}
	public Purchasable(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice,int tn) {
		super(position,name,color);
		this.RentPrice=rentprice;
		this.PurchasePrice=purchaseprice;
		this.HypothecPrice=hypothecprice;
		this.isSold=false;
		this.totalNeighbor=tn;
	}
	

	//getters and setters
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
