import java.util.ArrayList;
import java.util.List;

public class MapTypes implements ISquareCreator {
	
	protected List<Square> Squares = new ArrayList<Square>(40);
	
	public MapTypes(){}
	
	@Override
	public Square createProperty(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice) {
		// TODO Auto-generated method stub
		return new Property(position,name,color,rentprice,purchaseprice,hypothecprice);
	}

	public void addSquare(Square square) {
		Squares.add( square );
	}
	
	public Square getProperty(int position) {
		return Squares.get(position);
	}
	
	public Square getSquare(int position) {
		return Squares.get(position);
	}

	@Override
	public Square createTransportation(int position, String name, String color, int rentprice, int purchaseprice,
			int hypothecprice) {
		// TODO Auto-generated method stub
		return new Transportation(position,name,color,rentprice,purchaseprice,hypothecprice);
	}

	@Override
	public Square createFirm(int position, String name, String color, int rentprice, int purchaseprice,
			int hypothecprice) {
		// TODO Auto-generated method stub
		return new Firm(position,name,color,rentprice,purchaseprice,hypothecprice);
	}

	@Override
	public Square createTax(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Tax(position,color,name);
	}

	@Override
	public Square createChance(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Chance(position,color,name);
	}

	@Override
	public Square createFund(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Fund(position,color,name);
	}

	@Override
	public Square createPark(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Park(position,color,name);
	}

	@Override
	public Square createVisit(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Visit(position,color,name);
	}

	@Override
	public Square createJail(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Jail(position,color,name);
	}

	@Override
	public Square createStart(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Start(position,color,name);
	}
	
}
