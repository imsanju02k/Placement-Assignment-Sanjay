package lecture14.LinkedList;

/*
You are given the `head` of a linked list with `n` nodes.

For each node in the list, find the value of the **next greater node**. That is, for each node, find the value of the first node that is next to it and has a **strictly larger** value than it.

Return an integer array `answer` where `answer[i]` is the value of the next greater node of the `ith` node (**1-indexed**). If the `ith` node does not have a next greater node, set `answer[i] = 0`.
Input: head = [2,1,5]
Output: [5,5,0]
*/
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Question7 {

    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        // Convert linked list to array
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int n = list.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int num = list.get(i);

            while (!stack.isEmpty() && num >= list.get(stack.peek())) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = list.get(stack.peek());
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        int[] result = nextLargerNodes(head);
        System.out.println(Arrays.toString(result));
    }
}


