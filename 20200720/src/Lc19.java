public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum=new ListNode(0);
        dum.next=head;
        ListNode cur=dum,pos=dum;

        for(int i=0;i<=n;i++){
            pos=pos.next;
        }
        while(pos!=null){
            pos=pos.next;
            cur=cur.next;
        }

        cur.next=cur.next.next;
        return dum.next;
    }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        //ListNode dum=new ListNode(0);
//        //dum.next=head;
//        ListNode cur= head,pos=head;
//
//        for(int i=0;i<=n;i++){
//            pos=pos.next;
//        }
//        while(pos!=null){
//            pos=pos.next;
//            cur=cur.next;
//        }
//
//        cur.next=cur.next.next;
//        return head;
//    }
}
