package lecture12.LinkedList;

/*
Given a linked list of N nodes. The task is to check if the linked list has a loop. Linked list can contain self loop.
Input:
N = 3
value[] = {1,3,4}
x(position at which tail is connected) = 2
Output:True
Explanation:In above test case N = 3.
The linked list with nodes N = 3 is
given. Then value of x=2 is given which
means last node is connected with xth
node of linked list. Therefore, there
exists a loop.
*/

class LinkedListNode  {
    int val;
    LinkedListNode  next;
    
    public LinkedListNode (int val) {
        this.val = val;
    }
}

public class Question2 {
    public static boolean hasLoop(LinkedListNode  head) {
    	LinkedListNode  slowPtr = head;
    	LinkedListNode  fastPtr = head;
        
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if (slowPtr == fastPtr) {
                return true; // Loop detected
            }
        }
        
        return false; // No loop found
    }
    
    public static void main(String[] args) {
    	LinkedListNode  head = new LinkedListNode (1);
        head.next = new LinkedListNode (3);
        head.next.next = new LinkedListNode (4);
        
        // Create a loop by connecting the tail to the second node
        head.next.next.next = head.next;
        
        boolean hasLoop = hasLoop(head);
        System.out.println("Does the linked list have a loop? " + hasLoop);
    }
}
