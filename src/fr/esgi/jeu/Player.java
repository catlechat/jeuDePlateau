package fr.esgi.jeu;

public class Player {
	private String name;
	private int position;
	
	public Player(String name) {
		this.name = name;
		this.position = 0;
	}
	public String getName() {
		return this.name;
	}
	public void move() {
		this.position += 4;
	}
	
}