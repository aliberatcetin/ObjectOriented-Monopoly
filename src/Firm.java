import java.util.Random;
public class Firm extends Purchasable{
	
	public Firm(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice,int tn) {
		super(position,name,color,rentprice,purchaseprice,hypothecprice,tn);
	}

	@Override
	public void Speak(Player player2) {
		if ( super.isSold() && !player2.getName().equals(getOwner().getName())) {
			System.out.print(player2.getName()+" moved to " + getName() + "("+ getPosition()+"). " );
			System.out.println(player2.getName()+" will pay rent("+ getRentPrice() +"$) x Total Dice"+" to "  + getOwner().getName()+". ");
		}else {
			System.out.print(player2.getName()+" moved to " + getName()+"("+getPosition()+"). " );
		}
	}
	//getdefaul rent price method
	//todo

	
}
