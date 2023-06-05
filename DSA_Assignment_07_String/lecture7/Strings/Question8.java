package lecture7.Strings;

/*

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

**Example 1:**
***Input:** coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]

**Output:** true

*/

public class Question8 {
	
	 public static boolean checkStraightLine(int[][] coordinates) {
	        if (coordinates.length < 3) {
	            return true;
	        }

	        int x1 = coordinates[0][0];
	        int y1 = coordinates[0][1];
	        int x2 = coordinates[1][0];
	        int y2 = coordinates[1][1];
	        double slope = (double) (y2 - y1) / (x2 - x1);

	        for (int i = 2; i < coordinates.length; i++) {
	            int x = coordinates[i][0];
	            int y = coordinates[i][1];
	            double currentSlope = (double) (y - y1) / (x - x1);

	            if (currentSlope != slope) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
	        boolean isStraightLine = checkStraightLine(coordinates);
	        System.out.println(isStraightLine);
	    }

	
}


