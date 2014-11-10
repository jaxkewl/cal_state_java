package Cards;

import java.util.Random;

public class CardDeck {

	String[] suitArray = { "Clubs", "Spade", "Heart", "Diamond" };
	String[] numArray = { "Jack", "Queen", "King", "Ace", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };

	String[] deck = new String[52];
	String[] shuffledDeck = new String[52];

	public CardDeck() {
		int c = 0;

		// initialize a new deck of cards
		for (int s = 0; s < suitArray.length; s++) {
			for (int n = 0; n < numArray.length; n++) {

				deck[c++] = suitArray[s] + " " + numArray[n];

			}

		}

	}

	public void outputDeck() {

		int count = 1;
		// new way to iterate through arrays
		for (String card : deck) {
			System.out.println(count + ") " + card);
			count++;
		}

	}

	public void outputOnlySuit(String suit) {

		for (int i = 0; i < deck.length; i++) {

			if (deck[i].contains(suit)) {
				System.out.println((i + 1) + " " + deck[i]);
			}
		}
	}

	public void shuffleDeck() {

		// create temporary card deck to hold shuffled deck
		String tempCard;

		// now shuffle
		for (int i = 0; i < deck.length; i++) {
			Random randCard = new Random();
			int randomInt = randCard.nextInt(51);

			tempCard = deck[i];
			deck[i] = deck[randomInt];
			deck[randomInt] = tempCard;

		}
	}
}
