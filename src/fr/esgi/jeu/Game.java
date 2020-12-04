package fr.esgi.jeu;

public class Game {
	private int id;
	private Plateau plateau;
	private Player[] players;
	
	
	public Game(int id, Plateau plateau, Player[] players) {
		this.id = id;
		this.plateau = plateau;
		this.players = players;
	}
	public void getAllPlayers() {
		System.out.println("Those are the players of this game:");
		for(int i = 0; i < this.players.length; i++) {
			System.out.println((i+1)+": "+this.players[i].getName());
		}
	}
	public void getPlateau() {
		System.out.println("They are playing on: "+this.plateau.getName());
	}
}
