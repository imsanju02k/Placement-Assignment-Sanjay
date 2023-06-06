package lecture10.Recursion;

/*

The tower of Hanoi is a famous puzzle where we have three rods and N disks. The objective of the puzzle is to move the entire stack to another rod. You are given the number of discs N. Initially, these discs are in the rod 1. You need to print all the steps of discs movement so that all the discs reach the 3rd rod. Also, you need to find the total moves.Note: The discs are arranged such that the top disc is numbered 1 and the bottom-most disc is numbered N. Also, all the discs have different sizes and a bigger disc cannot be put on the top of a smaller disc. Refer the provided link to get a better clarity about the puzzle.


*/

public class Question6 {

    public static void moveDiscs(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        moveDiscs(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moveDiscs(n - 1, auxiliary, source, destination);
    }
    
    public static void towerOfHanoi(int n) {
        int totalMoves = (int) Math.pow(2, n) - 1;
        System.out.println("Total moves required: " + totalMoves);
        moveDiscs(n, 'A', 'B', 'C');
    }

    public static void main(String[] args) {
        int discs = 3;
        towerOfHanoi(discs);
    }

}
