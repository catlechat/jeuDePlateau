package fr.esgi.jeu;

import java.util.ArrayList;

public class Square {
	private Effect effect;
	// private Player[] players;
	private ArrayList<Player> players;

	public Square(Effect effect) {
		this.effect = effect;
		this.players = new ArrayList<Player>();
	}

	public Effect getEffect() {
		return this.effect;
	}

	public void setPlayer(Player player) {
		this.players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}
}
