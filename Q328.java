328. Odd Even Linked List  
Total Accepted: 30140 Total Submissions: 79110 Difficulty: Medium

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ... 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
        public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode headEven = even;
        ListNode prev = head;
        while(odd != null && even != null){
            odd.next = even.next;
            prev = odd;
            odd = odd.next;
            if (odd != null){
                even.next = odd.next;
                even = even.next;
            }
        }
        if (odd != null) odd.next = headEven;
        else prev.next = headEven;
        return head;
    }
    
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode oddHead = head;
        while (head != null && head.next != null){
            ListNode tmp = head.next;
            head.next = head.next.next;
            head = tmp;
        }
        ListNode oddEnd = getEndNode(oddHead);
        oddEnd.next = evenHead;
        return oddHead;
    }
    private ListNode getEndNode(ListNode head){
        ListNode copy = head;
        while(copy.next != null){
            copy = copy.next;
        }
        return copy;
    }
}
