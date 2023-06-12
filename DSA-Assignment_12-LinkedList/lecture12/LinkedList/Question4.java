package lecture12.LinkedList;


/*
Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
> Input: R->A->D->A->R->NULL
> 
> 
> **Output:** Yes
> 
> **Input:** C->O->D->E->NULL
> 
> **Output:** No
>
*/



class ListNode {
    char val;
    ListNode next;
    
    public ListNode(char val) {
        this.val = val;
    }
}

public class Question4 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        // Move slowPtr to the middle of the linked list and reverse the first half
        ListNode prev = null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            
            ListNode next = slowPtr.next;
            slowPtr.next = prev;
            prev = slowPtr;
            slowPtr = next;
        }
        
        // If the linked list has an odd number of nodes, move slowPtr one step forward
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }
        
        // Compare the reversed first half with the second half
        while (slowPtr != null) {
            if (slowPtr.val != prev.val) {
                return false; // Not a palindrome
            }
            slowPtr = slowPtr.next;
            prev = prev.next;
        }
        
        return true; // Palindrome
    }
    
    public static void main(String[] args) {
        ListNode head1 = new ListNode('R');
        head1.next = new ListNode('A');
        head1.next.next = new ListNode('D');
        head1.next.next.next = new ListNode('A');
        head1.next.next.next.next = new ListNode('R');
        
        boolean isPalindrome1 = isPalindrome(head1);
        System.out.println("Is the linked list a palindrome? " + (isPalindrome1 ? "Yes" : "No"));
        
        ListNode head2 = new ListNode('C');
        head2.next = new ListNode('O');
        head2.next.next = new ListNode('D');
        head2.next.next.next = new ListNode('E');
        
        boolean isPalindrome2 = isPalindrome(head2);
        System.out.println("Is the linked list a palindrome? " + (isPalindrome2 ? "Yes" : "No"));
    }
}
