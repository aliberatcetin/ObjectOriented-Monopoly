import java.util.ArrayList;
import java.util.List;

public class DefaultMap{
	
	private List<Square> Squares = new ArrayList<Square>();
	
	public DefaultMap(){}


	//creates a property and returns it;
	private Square createProperty(int position,String name,String color,int rentprice,int purchaseprice,int hypothecprice,int tn) {
		// TODO Auto-generated method stub
		return new Property(position,name,color,rentprice,purchaseprice,hypothecprice,tn);
	}

	//add a square in to square array;
	private void addSquare(Square square) {
		Squares.add( square );
	}


	public Square getProperty(int position) {
		return Squares.get(position);
	}
	
	public Square getSquare(int position) {
		return Squares.get(position);
	}

	//creates 40 square and adds them into square array.
	public void createMap() {		
		addSquare( createStart         (0,"start","transparent") );
		addSquare( createProperty      (1,"sisli","brown",20,600,300,2));
		addSquare( createFund	       (2,"fund","transparent") );
		addSquare( createProperty	   (3,"mecidiyekoy","brown",40,600,300,2));
		addSquare( createTax           (4,"tax","transparent",2000) );
		addSquare( createTransportation(5,"tramline","transparent",250,2000,1000,4));
		addSquare( createProperty      (6,"anadoluhisari","skyblue",60,1000,500,3));
		addSquare( createChance        (7,"chance","transparent") );
		addSquare( createProperty      (8,"beylerbeyi","skyblue",60,1000,500,3));
		addSquare( createProperty      (9,"uskudar","skyblue",80,1200,600,3));
		addSquare( createVisit         (10,"visit","transparent") );
		addSquare( createProperty      (11,"ortakoy","pink",100,1400,600,3));
		addSquare( createFirm          (12,"telecom","transparent",40,1500,750,2) );
		addSquare( createProperty      (13,"besiktas","pink",100,1400,700,3));
		addSquare( createProperty      (14,"taksim","pink",120,1600,800,3));
		addSquare( createTransportation(15,"airport","transparent", 250,2000,1000,4)     );
		addSquare( createProperty      (16,"atakoy","orange",140,1800,900,3) );
		addSquare( createFund          (17,"fund","transparent") );
		addSquare( createProperty      (18,"yesilkoy","orange",140,1800,900,3) );
		addSquare( createProperty      (19,"bahcesehir","orange",160,2000,1000,3) );
		addSquare( createPark          (20,"park","transparent") );
		addSquare( createProperty      (21,"atasehir","red",180,2200,1100,3)  );
		addSquare( createChance        (22,"change","transparent"));
		addSquare( createProperty      (23,"bostanci","red",180,2200,1100,3)  );
		addSquare( createProperty      (24,"bagdat caddesi","red",200,2400,1200,3)  );
		addSquare( createTransportation(25,"marine","transparent", 250,2000,1000,4)     );
		addSquare( createProperty      (26,"teskiviye","yellow",220,2600,1300,3)  );
		addSquare( createProperty      (27,"nisantasi","yellow",220,2600,1300,3)  );
		addSquare( createFirm          (28,"gas","transparent",40,1500,750,2) );
		addSquare( createProperty      (29,"macka","yellow",240,2800,1400,3)  );
		addSquare( createJail          (30,"jail","transparent") );
		addSquare( createProperty      (31,"emirgan","green",260,3000,1500,3)  );
		addSquare( createProperty      (32,"bebek","green",260,3000,1500,3)  );
		addSquare( createFund          (33,"fund","transparent") );
		addSquare( createProperty      (34,"yenikoy","green",280,3200,1600,3)  );
		addSquare( createTransportation(35,"subway","transparent",250,2000,1000,4)   );
		addSquare( createChance        (36,"chance","transparent") );
		addSquare( createProperty      (37,"levent","blue",350,3500,1750,2)  );
		addSquare( createTax           (38,"tax","transparent",1000) );
		addSquare( createProperty      (39,"etiler","blue",500,4000,2000,2)  );

	}
	
	//creates a transportation and returns it;
	private Square createTransportation(int position, String name, String color, int rentprice, int purchaseprice,
			int hypothecprice,int tn) {
		// TODO Auto-generated method stub
		return new Transportation(position,name,color,rentprice,purchaseprice,hypothecprice,tn);
	}
	//creates a firm and return it;
	private Square createFirm(int position, String name, String color, int rentprice, int purchaseprice,
			int hypothecprice,int tn) {
		// TODO Auto-generated method stub
		return new Firm(position,name,color,rentprice,purchaseprice,hypothecprice,tn);
	}
	//creates a tax and returns it;
	private Square createTax(int position, String color, String name,int tax) {
		// TODO Auto-generated method stub
		return new Tax(position,color,name,tax);
	}

	//creates a chance and returns it;
	private Square createChance(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Chance(position,color,name);
	}
	//creates a fund and returns it;
	private Square createFund(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Fund(position,color,name);
	}
	//creates a park and returns it;
	private Square createPark(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Park(position,color,name);
	}
	//creates a visit and returns it;
	private Square createVisit(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Visit(position,color,name);
	}
	//creates a jail and returns it;
	private Square createJail(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Jail(position,color,name);
	}
	//creates a start and returns it;
	private Square createStart(int position, String color, String name) {
		// TODO Auto-generated method stub
		return new Start(position,color,name);
	}

	
}