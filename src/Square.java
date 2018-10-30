
public abstract class Square {
	
	private int Position;
	private String Color;
	private String Name;
	
	public Square(int position,String name,String color) {
		this.Position=position;
		this.Color=color;
		this.Name=name;
	}

	public int getPosition() {
		return Position;
	}
	
	public abstract void Speak(Player player);
	
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
