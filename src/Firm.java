
public class Firm extends Purchasable{
	
	private int heyo;
	public Firm(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice,int tn) {
		super(position,name,color,rentprice,purchaseprice,hypothecprice,tn);
	}
	
	
	public int getRentPrice(int Dice) {
		return super.getRentPrice()*Dice;
	}
	
}
