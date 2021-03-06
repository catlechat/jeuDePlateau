package fr.esgi.jeu;

public enum Effect {

	BEGIN(0, "It's the beginning, everyone start with 5 coins!", 5),
	EMPTY(1, "Nothing happened.", 0),
	BONUS(2, "You gain 6 coins!", 6),
	LOOSE(3, "You loose 2 coins...", 2),
	PEN4A(4, "What the *family friendly game*, everyone loose 1 coin!", 1);

	private final int id;
	private final String message;
	private final int coins;

	Effect(int id, String message, int coins) {
		this.id = id;
		this.message = message;
		this.coins = coins;
	}

	public String getMessage() {
		return this.message;
	}

	public int getCoins() {
		return this.coins;
	}
}
