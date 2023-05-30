package lecture4.TwoDArrays;

public class Question7 {
	 public static int maxCount(int m, int n, int[][] ops) {
	        int minRow = m;
	        int minCol = n;

	        for (int[] op : ops) {
	            minRow = Math.min(minRow, op[0]);
	            minCol = Math.min(minCol, op[1]);
	        }

	        return minRow * minCol;
	    }

	    public static void main(String[] args) {
	        int m = 3;
	        int n = 3;
	        int[][] ops = {{2, 2}, {3, 3}};
	        int maxIntegers = maxCount(m, n, ops);
	        System.out.println("Number of maximum integers: " + maxIntegers);
	    }
	}