
public class 环的入口节点 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null && pHead.next==null){
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        slow=pHead;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
