
public interface ISquareCreator {
	public Square createProperty(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice);
	public Square createTransportation(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice);
	public Square createFirm(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice);
	public Square createTax(int position,String color,String name,int tax);
	public Square createChance(int position,String color,String name);
	public Square createFund(int position,String color,String name);
	public Square createPark(int position,String color,String name);
	public Square createVisit(int position,String color,String name);
	public Square createJail(int position,String color,String name);
	public Square createStart(int position,String color,String name);	
}
