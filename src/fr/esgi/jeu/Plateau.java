package fr.esgi.jeu;

public class Plateau {
	private String name;
	private int size;
	private int[] caises;
	
	public Plateau(String name, int size, int[] caises){
		this.name = name;
		this.size = size;
		this.caises = caises;
	}
	public String getName() {
		return this.name;
	}
}
