package human;

import java.util.Scanner;
import board.Board;
import board.MarkerType;
import board.Player;
import polygon.Point;
import polygon.PolygonMaker;

public class HumanPlayer extends Player {
	
	/* Scanner */
	private Scanner scanner;
	
	/**
	 * 
	 * @param name Name of player
	 */
	public HumanPlayer(String name) {
		super(name);
		scanner = new Scanner(System.in);
	}
	
	/**
	 * 
	 * @param type Type of marker
	 * @param board Tic tac toe board passed in
	 */
	public Point getPlay(MarkerType type, Board board) {
		System.out.println(getName() + ", select play(row, column): ");
		return PolygonMaker.getPoint(scanner);
	}
}