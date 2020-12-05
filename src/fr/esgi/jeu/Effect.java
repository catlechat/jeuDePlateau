package fr.esgi.jeu;

public enum Effect {

	BEGIN(0, "It's the beginning, everyone start with 10 coins!", 10),
	NEUTRAL(1, "Nothing happened.", 0),
	BONUS(2, "You gain 2 coins!", 2),
	PENALTY(3, "You loose 2 coins...", 2),
	PENALTY_FOR_EVERYONE(4, "What the hell everyone loose 5 coins!", 5);
	
	private int id;
	private String message;
	private int coins;
	
	Effect(int id, String message, int coins){
		this.id = id;
		this.message = message;
		this.coins = coins;
	}
	public int getId(){
		return this.id;
	}
	public String getMessage(){
		return this.message;
	}
	public int getCoins(){
		return this.coins;
	}
}
