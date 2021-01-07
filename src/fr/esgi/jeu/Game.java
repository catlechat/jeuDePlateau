package fr.esgi.jeu;

import java.util.Scanner;

public class Game {
	private static final int CONDITION_COINS_TO_WIN = 20;
	private static final int FIRST_BOARD_CASE = 0;
	private static final int BONUS_PRICE = 4;
	private static final int EMPTY_PRICE = 1;
	private static final int LOOSE_PRICE = 2;
	private static final int PEN4A_PRICE = 3;

	private final int id;
	private final Board board;
	private final Player[] players;
	private int turn;

	public Square previousSquare;
	public Square curentSquare;

	public Game(int id, Board board, Player[] players) {
		this.id = id;
		this.board = board;
		this.players = players;
		this.turn = 1;
	}

	public void setPlayersInBeginning() {
		for (Player player : this.players) {
			this.board.getSquares()[FIRST_BOARD_CASE].setPlayer(player);
			player.setCoins(Effect.BEGIN);
		}
	}

	//fonction qui va faire le jeu et qui va retourner le nom du joueur gagnant
	public void start() {
		setPlayersInBeginning();
		System.out.println(board.toString());
		System.out.println(Effect.BEGIN.getMessage());
		while (true) {
			for (Player player : players) {
				int positionBeginTurn = player.getPosition();
				//player is moving
				Scanner scanner = new Scanner(System.in);
				boolean waiting = true;
				while(waiting){
					System.out.println(player.getName() + " what do you want to do ?");
					System.out.println("1. Use dice 2. Use coins 3. Print board 4. Exit");
					System.out.print("Select : >");
					switch (scanner.nextInt()) {
						case 1 ->{
							System.out.println(player.useDice());
							waiting = false;
						}
						case 2 -> {
							//ici on mets une fonction qui va demander ce qu'il veut faire avec ces points
							//Acheter et transformer une caise negative ou positive
							//
							System.out.println("You have "+player.getCoins()+" coins");
							System.out.println("How do you want to spend coins ?");
							System.out.println("1. Set a case to BONUS effect for "+BONUS_PRICE+" coins");
							System.out.println("2. Set a case to LOOSE effect for "+LOOSE_PRICE+" coins");
							System.out.println("3. Set a case to EMPTY effect for "+EMPTY_PRICE+" coins");
							System.out.println("4. Set a case to PEN4A effect for "+PEN4A_PRICE+" coins");
							System.out.println("5. Go back");
							int res = scanner.nextInt();
							int price;
							Effect selectedEffect;
							if (res == 1){
								price = BONUS_PRICE;
								selectedEffect = Effect.BONUS;
							}else if(res == 2){
								price = LOOSE_PRICE;
								selectedEffect = Effect.LOOSE;
							}else if(res == 3){
								price = EMPTY_PRICE;
								selectedEffect = Effect.EMPTY;
							}else if(res == 4){
								price = PEN4A_PRICE;
								selectedEffect = Effect.PEN4A;
							}else{
								break;
							}
							if (price > player.getCoins()){
								System.out.println("You don't have enough coins !");
								break;
							}
							System.out.println("What case do you want to set ?");
							System.out.println(board.toString());
							int selectedCase;
							do {
								System.out.println("Please select the case:");
								selectedCase = scanner.nextInt();
								if (selectedCase < 0 || selectedCase > board.getSize() || board.getSquares()[selectedCase].getEffect() == selectedEffect) {
									System.out.println("No such case or the case selected has allready this effect !");
								}
							} while (selectedCase < 0 || selectedCase > board.getSize() || board.getSquares()[selectedCase].getEffect() == selectedEffect);
							System.out.println("This case :");
							System.out.println(board.getSquares()[selectedCase].toString(selectedCase));
							System.out.println("Becomes :");
							player.setCoins(price);
							board.getSquares()[selectedCase].setEffect(selectedEffect);
							System.out.println(board.getSquares()[selectedCase].toString(selectedCase));
						}
						case 3 -> {
							System.out.println("Printing board..");
							System.out.println(board.toString());
						}
						case 4 -> {
							System.out.println("Do you want to save the game before exit ?");
							System.out.println("1. Yes 2. NO");
							int rep = scanner.nextInt();
							if(rep==1){
								//ici on enregistre la game dans la bdd et on lui retourne un code de la game
								return;
							}else{
								return;
							}
						}
						default -> System.out.println("Not implemented yet..");
					}
				}
				if (player.getPosition() >= board.getSize()) {
					player.setPosition(player.getPosition() - board.getSize());
				}
				//youre on new case, what effect do you get ??
				previousSquare = board.getSquares()[positionBeginTurn];
				previousSquare.removePlayer(player);
				curentSquare = board.getSquares()[player.getPosition()];
				curentSquare.setPlayer(player);
				Effect currentEfect = curentSquare.getEffect();
				System.out.println(currentEfect.getMessage()+"\n");
				player.setCoins(currentEfect);

				if (player.getCoins() >= CONDITION_COINS_TO_WIN) {
					System.out.println("Game Over, the winner is: "
							+player.getName()+" with: "+player.getCoins()+" coins.");
					return;
				}
			}
			this.turn++;
			System.out.println(this.toString());
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//on affiche les info utiles comme le tour
		sb.append("Here the current state of the game: Turn ").append(this.turn).append(":\n");
		sb.append("-----------------------------\n");
		//pour chaque joueur on affiche sa position, ses coins et la caise sur laquelle il est
		for (Player player : players) {
			sb.append(player.toString());
			sb.append(this.board.getSquares()[player.getPosition()].toString(player.getPosition()));
			sb.append("-----------------------------\n");
		}
		return sb.toString();
	}
}
