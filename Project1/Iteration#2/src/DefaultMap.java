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
		addSquare( createStart         (0,"start","TRANSPARENT") );
		addSquare( createProperty      (1,"sisli","BROWN",20,600,300,2));
		addSquare( createFund	       (2,"fund","TRANSPARENT") );
		addSquare( createProperty	   (3,"mecidiyekoy","BROWN",40,600,300,2));
		addSquare( createTax           (4,"tax","TRANSPARENT",2000) );
		addSquare( createTransportation(5,"tramline","TRANSPARENT",250,2000,1000,4));
		addSquare( createProperty      (6,"anadoluhisari","SKYBLUE",60,1000,500,3));
		addSquare( createChance        (7,"chance","TRANSPARENT") );
		addSquare( createProperty      (8,"beylerbeyi","SKYBLUE",60,1000,500,3));
		addSquare( createProperty      (9,"uskudar","SKYBLUE",80,1200,600,3));
		addSquare( createVisit         (10,"visit","TRANSPARENT") );
		addSquare( createProperty      (11,"ortakoy","PINK",100,1400,600,3));
		addSquare( createFirm          (12,"telecom","TRANSPARENT",40,1500,750,2) );
		addSquare( createProperty      (13,"besiktas","PINK",100,1400,700,3));
		addSquare( createProperty      (14,"taksim","PINK",120,1600,800,3));
		addSquare( createTransportation(15,"airport","TRANSPARENT", 250,2000,1000,4)     );
		addSquare( createProperty      (16,"atakoy","ORANGE",140,1800,900,3) );
		addSquare( createFund          (17,"fund","TRANSPARENT") );
		addSquare( createProperty      (18,"yesilkoy","ORANGE",140,1800,900,3) );
		addSquare( createProperty      (19,"bahcesehir","ORANGE",160,2000,1000,3) );
		addSquare( createPark          (20,"park","TRANSPARENT") );
		addSquare( createProperty      (21,"atasehir","RED",180,2200,1100,3)  );
		addSquare( createChance        (22,"change","TRANSPARENT"));
		addSquare( createProperty      (23,"bostanci","RED",180,2200,1100,3)  );
		addSquare( createProperty      (24,"bagdat caddesi","RED",200,2400,1200,3)  );
		addSquare( createTransportation(25,"marine","TRANSPARENT", 250,2000,1000,4)     );
		addSquare( createProperty      (26,"teskiviye","YELLOW",220,2600,1300,3)  );
		addSquare( createProperty      (27,"nisantasi","YELLOW",220,2600,1300,3)  );
		addSquare( createFirm          (28,"gas","TRANSPARENT",40,1500,750,2) );
		addSquare( createProperty      (29,"macka","YELLOW",240,2800,1400,3)  );
		addSquare( createJail          (30,"jail","TRANSPARENT") );
		addSquare( createProperty      (31,"emirgan","GREEN",260,3000,1500,3)  );
		addSquare( createProperty      (32,"bebek","GREEN",260,3000,1500,3)  );
		addSquare( createFund          (33,"fund","TRANSPARENT") );
		addSquare( createProperty      (34,"yenikoy","GREEN",280,3200,1600,3)  );
		addSquare( createTransportation(35,"subway","TRANSPARENT",250,2000,1000,4)   );
		addSquare( createChance        (36,"chance","TRANSPARENT") );
		addSquare( createProperty      (37,"levent","BLUE",350,3500,1750,2)  );
		addSquare( createTax           (38,"tax","TRANSPARENT",1000) );
		addSquare( createProperty      (39,"etiler","BLUE",500,4000,2000,2)  );

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