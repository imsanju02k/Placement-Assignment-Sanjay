package lecture19.SearchingAndSorting;

/*You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

*Merge all the linked-lists into one sorted linked-list and return it.
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6


**/

import java.util.PriorityQueue;

public class Question1 {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue to store the nodes of the linked lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head nodes of all the linked lists to the priority queue
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Create a dummy node to build the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the nodes in the priority queue until it is empty
        while (!pq.isEmpty()) {
            // Remove the node with the smallest value from the priority queue
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            // Add the next node from the same linked list to the priority queue
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create the example linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // Create the array of linked lists
        ListNode[] lists = {l1, l2, l3};

        // Merge the linked lists
        Question1 merger = new Question1();
        ListNode mergedList = merger.mergeKLists(lists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println();
    }
}
