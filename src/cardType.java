
public enum CardType {
	   one(1),
	   two(2),
	   three(3),
	   four(4),
	   five(5),
	   six(6);
	   
	   private int cardIndex;

	   private CardType(int cardIndex) { this.cardIndex = cardIndex; }

	   public static String getLeg(int cardIndex) {
	      for (CardType l : CardType.values()) {
	          if (l.cardIndex == cardIndex) return l.toString();
	      }
	      throw new IllegalArgumentException("fake");
	   }
}
