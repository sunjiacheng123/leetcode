
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class 删除链表中的重复的节点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode next=pHead.next;
        if(next.val==pHead.val){
            while(next!=null && pHead.val==next.val){
                next=next.next;
            }
            return deleteDuplication(next);
        }else {
            pHead.next=deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
