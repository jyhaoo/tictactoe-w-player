package polygon;

import java.util.ArrayList;

public class Polygon extends LineList {
	
	ArrayList<Point> points;
	
	/**
	 * Initialize arraylist of points
	 */
	public Polygon() {
		points = new ArrayList<Point>();
	}
	
	/**
	 * 
	 * @param x Add new point with x value
	 * @param y Add new point with y value
	 */
	public void addPoint(int x, int y) {
		Point newEndPoint = new Point(x, y);
		points.add(newEndPoint);
		
		if (points.size() == 1) {
			return;
		}
		
		Point startPoint = points.get(0);
		if (points.size() == 2) {
			addLine(startPoint, newEndPoint);
		}
		
		Point oldEndPoint = points.get(points.size() - 2);
		if (startPoint != oldEndPoint) {
			addLine(startPoint, newEndPoint);
			return;
		}
		
		addLine(oldEndPoint, newEndPoint);
		addLine(newEndPoint, startPoint);
	}
	
	/**
	 * 
	 * @return Number of points in arraylist of points
	 */
	int getNumberVertices() {
		return points.size();
	}
}








