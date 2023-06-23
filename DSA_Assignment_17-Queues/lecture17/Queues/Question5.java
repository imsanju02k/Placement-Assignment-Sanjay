package lecture17.Queues;

/*

There are `n` friends that are playing a game. The friends are sitting in a circle and are numbered from `1` to `n` in **clockwise order**. More formally, moving clockwise from the `ith` friend brings you to the `(i+1)th` friend for `1 <= i < n`, and moving clockwise from the `nth` friend brings you to the `1st` friend.

The rules of the game are as follows:

1. **Start** at the `1st` friend.
2. Count the next `k` friends in the clockwise direction **including** the friend you started at. The counting wraps around the circle and may count some friends more than once.
3. The last friend you counted leaves the circle and loses the game.
4. If there is still more than one friend in the circle, go back to step `2` **starting** from the friend **immediately clockwise** of the friend who just lost and repeat.
5. Else, the last friend in the circle wins the game.

Given the number of friends, `n`, and an integer `k`, return *the winner of the game*.

Input: n = 5, k = 2
Output: 3
Explanation: Here are the steps of the game:
1) Start at friend 1.
2) Count 2 friends clockwise, which are friends 1 and 2.
3) Friend 2 leaves the circle. Next start is friend 3.
4) Count 2 friends clockwise, which are friends 3 and 4.
5) Friend 4 leaves the circle. Next start is friend 5.
6) Count 2 friends clockwise, which are friends 5 and 1.
7) Friend 1 leaves the circle. Next start is friend 3.
8) Count 2 friends clockwise, which are friends 3 and 5.
9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner

*/

public class Question5 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int findTheWinner(int n, int k) {
        ListNode head = buildCircularLinkedList(n);

        // Start at friend 1
        ListNode current = head;
        ListNode prev = null;

        while (current.next != current) {
            // Count k-1 friends
            for (int i = 0; i < k - 1; i++) {
                prev = current;
                current = current.next;
            }

            // Remove the friend
            prev.next = current.next;
            current = prev.next;
        }

        // The last friend remaining is the winner
        return current.val;
    }

    private static ListNode buildCircularLinkedList(int n) {
        ListNode head = new ListNode(1);
        ListNode current = head;

        for (int i = 2; i <= n; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        current.next = head; // Make the linked list circular

        return head;
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        int winner = findTheWinner(n, k);
        System.out.println("The winner of the game: " + winner);
    }
}
