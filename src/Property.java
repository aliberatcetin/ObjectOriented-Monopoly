
public abstract class Property {
	
	private int RentPrice;
	private int PurchasePrice;
	private int Position;
	private String Color;
	private String Name;
	private int HypotehecPrice;
	public Property(int position,String color,String name,int rentprice,int purchaseprice,int hypothecprice) {
		this.Position=position;
		this.Color=color;
		this.Name=name;
		this.RentPrice=rentprice;
		this.PurchasePrice=purchaseprice;
		this.HypotehecPrice=hypothecprice;
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

	public int getPosition() {
		return Position;
	}

	public void setPosition(int position) {
		Position = position;
	}

	public int getHypotehecPrice() {
		return HypotehecPrice;
	}

	public void setHypotehecPrice(int hypotehecPrice) {
		HypotehecPrice = hypotehecPrice;
	}

	public void setColor(String color) {
		Color = color;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getColor() {
		return Color;
	}

	public String getName() {
		return Name;
	}
}
