//square class to represent the attributes and functionalities of "squares" of the monopoly game.
public abstract class Square {
	
	private int Position;
	private String Color;
	private String Name;
	
	public Square(int position,String name,String color) {
		this.Position=position;
		this.Color=color;
		this.Name=name;
	}

	//when a player comes in a square, game class calls this method.
    //it prints the player name, square name and the event will happen.
	public abstract void Speak(Player player);


	//getters and setters
	public int getPosition() {
		return Position;
	}

	public void setPosition(int position) {
		Position = position;
	}

	public void setColor(String color) {
		Color = color;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getColor() {
		return Color;
	}

	public String getName() {
		return Name;
	}
}
