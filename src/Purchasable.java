
public class Purchasable extends Square {
	private int RentPrice;
	private int PurchasePrice;
	private int HypothecPrice;
	public Purchasable(int position,String color,String name,int rentprice,int purchaseprice,int hypothecprice) {
		super(position,color,name);
		this.RentPrice=rentprice;
		this.PurchasePrice=purchaseprice;
		this.HypothecPrice=hypothecprice;
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
