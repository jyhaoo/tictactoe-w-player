package computerPlayer;

import board.Board;
import board.MarkerType;
import board.Player;
import board.Cell;
import polygon.PolygonMaker;
import polygon.Point;
import java.util.Random;

public class ComputerPlayerR extends Player {
	
	public ComputerPlayerR(String name) {
		super(name);
	}
	
	public Point getPlay(MarkerType type, Board board) {
		Random rand1 = new Random();
		Random rand2 = new Random();
		boolean playAble = false;
		
		while(!playAble) {
			int randomNum1 = rand1.nextInt(3);
			int randomNum2 = rand2.nextInt(3);
			
			Cell[][] cells = board.getCells();
			if (!cells[randomNum1][randomNum2].isFilled()) {
				return new Point(randomNum1, randomNum2);
			} 
		}
		return null;
	}
}
