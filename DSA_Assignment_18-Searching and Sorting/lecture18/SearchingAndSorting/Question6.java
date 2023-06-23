package lecture18.SearchingAndSorting;

/*

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array `points` where `points[i] = [xstart, xend]` denotes a balloon whose **horizontal diameter** stretches between `xstart` and `xend`. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up **directly vertically** (in the positive y-direction) from different points along the x-axis. A balloon with `xstart` and `xend` is **burst** by an arrow shot at `x` if `xstart <= x <= xend`. There is **no limit** to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array `points`, return *the **minimum** number of arrows that must be shot to burst all balloons*.

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].




*/

import java.util.Arrays;

public class Question6 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the balloons based on their end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow is needed
        int currentEnd = points[0][1]; // Initial end position

        for (int i = 1; i < points.length; i++) {
            // If the start position is greater than the current end position,
            // we need to shoot a new arrow
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1]; // Update the current end position
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        Question6 solution = new Question6();
        int minArrows = solution.findMinArrowShots(points);

        System.out.println("Minimum number of arrows needed: " + minArrows);
    }
}
