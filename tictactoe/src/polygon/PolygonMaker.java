package polygon;

import java.util.Scanner;

public class PolygonMaker {
	
	static public Point getPoint(Scanner scanner) {
		
		while(true) {
			String pointString = scanner.nextLine();
			
			if (pointString.length() == 0) {
				return null;
			}
			
			int index = pointString.indexOf(",");
			if (index == -1) {
				System.out.println("Values must be comma-separated, try again.");
				continue;
			}
			String xString = pointString.substring(0, index).trim();
			String yString = pointString.substring(index+1).trim();
			int x = 0;
			int y = 0;
			
			try {
				x = Integer.parseInt(xString);
				y = Integer.parseInt(yString);
			} catch (NumberFormatException e) {
				System.out.println("Values must be integers, try again");
				continue;
			}
			return new Point(x, y);
		}
	}
}