package fr.esgi.jeu;

import java.util.ArrayList;

public class Square {
	private int id;
	private Effect effect;
	//private Player[] players;
	private ArrayList<Player> players;

	public Square(int id, Effect effect) {
		this.id = id;
		this.effect = effect;
		this.players = new ArrayList<Player>();
	}
	//constructeur de la case du début
	public Square() {
		Effect effect = Effect.BEGIN;
		this.id = 0;
		this.effect = effect;
		this.players = new ArrayList<Player>();
	}
	//constructeur de la case de fin
	public Square(int id) {
		this.id = id;
		this.effect = null;
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
