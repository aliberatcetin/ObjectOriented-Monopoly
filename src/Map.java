public class Map {
	
	MapTypes Map = new MapTypes();
    public Map() {
    	
    }
    
    public void setMap(MapTypes mt) {
    	this.Map=mt;
    }
    
    public Square getSquare(int position) {
    	return Map.getSquare(position);
    }
    
   
    
    
}
