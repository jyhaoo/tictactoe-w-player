package board;

import polygon.LineList;
import polygon.Point;

public class XMarker extends LineList implements Marker {
	
	/**
	 * 
	 * @param size Size of polygon
	 * @param left Position on board
	 * @param top Position on board
	 */
	XMarker(int size, int left, int top) {
		super(false);
		addLine(new Point(left, top), new Point(left + size, top + size));
		addLine(new Point(left, top + size), new Point(left + size, top));
	}
	
	/**
	 * Remove the marker
	 */
	public void delete() {
		removeAll();
	}
}