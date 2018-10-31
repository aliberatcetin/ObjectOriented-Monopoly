import java.util.Random;
public class Firm extends Purchasable{
	
	private int heyo;
	public Firm(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice,int tn) {
		super(position,name,color,rentprice,purchaseprice,hypothecprice,tn);
	}
	
	
	public int getRentPrice() {
		Random random = new Random();
		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);
		int diceSum = dice1 + dice2;
		return diceSum * super.getRentPrice();
	}
	
}
