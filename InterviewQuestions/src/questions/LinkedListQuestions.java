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
}
