package questions;

import questions.InterviewQuestions.ListNode;

public class LinkedListQuestions {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p = headA;
        int m = 1, n = 1;
        while(p.next!=null){
            m++;
            p = p.next;
        }
        p = headB;
        while(p.next!=null){
            p = p.next;
            n++;
        }
        ListNode p1 = headA, p2 = headB;
        if( m>=n ){
            for(int i = 0; i<(m-n);i++){
                p1 = p1.next;
            }
        }
        if(m<n){
            for(int i = 0; i<(n-m);i++){
                p2 = p2.next;
            }
        }
        
        while(p1!=null&&p2!=null){
            if(p1 == p2){
                return p1;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        
        return null;
    }
    
    public static void reorderList(ListNode head) {
        if(head==null || head.next == null || head.next.next == null){
            return;
        }
        
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstHalf = head, secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);
        while(firstHalf!=null&&secondHalf!=null){
            ListNode q1 = firstHalf.next, q2 = secondHalf.next;

        	firstHalf.next = secondHalf;
            secondHalf.next = q1;
            firstHalf = q1;
            secondHalf = q2;
        }
        
        while(head!=null){
        	System.out.println(head.val);
        	head = head.next;
        }
    }
    
     public static ListNode reverse(ListNode head) {
 
        if (head == null || head.next == null)
            return head;
 
        ListNode pre = head;
        ListNode curr = head.next;
 
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
 
        // set head node's next
        head.next = null;
 
        return pre;
    }
}
