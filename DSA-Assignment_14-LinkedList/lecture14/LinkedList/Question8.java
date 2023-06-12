package lecture14.LinkedList;

/*
.
Given the `head` of a linked list, we repeatedly delete consecutive sequences of nodes that sum to `0` until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

(Note that in the examples below, all sequences are serializations of `ListNode` objects.)
Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.

*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Question8 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        int cumulativeSum = 0;

        while (fast != null) {
            cumulativeSum += fast.val;

            if (cumulativeSum == 0) {
                slow.next = fast.next;
            }

            fast = fast.next;

            if (cumulativeSum != 0) {
                slow = slow.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        Question8 solution = new Question8();
        ListNode result = solution.removeZeroSumSublists(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
