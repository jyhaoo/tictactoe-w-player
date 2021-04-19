package polygon;

public class Point {
		
	private final int x;
	private final int y;
	
	/**
	 * 
	 * @param x X position
	 * @param y Y position
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param otherPoint Other point being compared
	 * @return Distance between the points
	 */
	double getDistance(Point otherPoint) {
		return Math.sqrt(Math.pow(otherPoint.x - x,  2) + Math.pow(otherPoint.y - y, 2));
	}
	
	/**
	 * 
	 * @return X of the point
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return Y of the point
	 */
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Point)) {
			return false;
		}
		Point otherPoint = (Point) other;
		return (otherPoint.x == x && otherPoint.y == y);
	}
	
	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
	
}