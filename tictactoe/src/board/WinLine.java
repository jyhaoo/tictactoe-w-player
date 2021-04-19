package board;

import polygon.Point;
import polygon.Polygon;

public class WinLine extends Polygon {
	
	/**
	 * 
	 * @param start Starting point of winning sequence
	 * @param end Ending point of winning sequence
	 */
	WinLine(Point start, Point end) {
		addPoint(start.getX(), start.getY());
		addPoint(end.getX(), end.getY());
	}
	
	/**
	 * Remove the WinLine
	 */
	void delete() {
		removeAll();
	}
}