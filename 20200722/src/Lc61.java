/*
找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
断开环 new_tail.next = None，并返回新的链表头 new_head。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
}
public class Lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        int n=1;
        if(head==null){
            return head;
        }
        ListNode cur=head;
        ListNode last=null;
        while(cur.next!=null){
            cur=cur.next;
            n++;
        }
        cur.next=head;
        ListNode tmp=head;
        //ListNode newlast=null;
        for(int i=0;i<(n-k%n-1);i++){
            //新尾
            tmp=tmp.next;
        }
        for(int i=0;i<(n-k%n);i++){
            //新头
            head=head.next;
        }
        tmp.next=null;
        return head;
    }
}
