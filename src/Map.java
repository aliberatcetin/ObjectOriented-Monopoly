public class Map {
	
	MapTypes Map = new MapTypes();
    public Map(MapTypes map) {
    	this.Map=map;
    }
    
    public Square getSquare(int position) {
    	return Map.getSquare(position);
    }
    
   
    
    
}
