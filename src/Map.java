public class Map {
	
	DefaultMap Map = new DefaultMap();
	
    public Map() {
    	Map.createMap();//creates a map
    }
    
    public Square getSquare(int position) {
    	return Map.getSquare(position);
    } 
}
