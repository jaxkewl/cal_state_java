package Cards;

public class CardDeckTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck cardDeck = new CardDeck();
		cardDeck.outputDeck();
		cardDeck.shuffleDeck();

		System.out.println("");
		cardDeck.outputDeck();

		System.out.println("");
		cardDeck.outputOnlySuit("Clubs");

		System.out.println("");
		cardDeck.outputOnlySuit("Spade");

		System.out.println("");
		cardDeck.outputOnlySuit("Heart");

		System.out.println("");
		cardDeck.outputOnlySuit("Diamond");
	}

}
