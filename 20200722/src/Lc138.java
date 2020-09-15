class Node {
    int val;
    Node next;
    Node random;

    public Node(int val,Node next,Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class Lc138 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while (cur!=null){
            Node tmp=new Node(cur.val,cur.next,null);
            cur.next=tmp;
            cur=cur.next.next;
        }
        cur=head;
        while (cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else {
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        cur=head;
        Node newHead=cur.next;
        while (cur.next!=null){
            Node tmp=cur.next;
            cur.next=tmp.next;
            cur=tmp;
        }
        return newHead;
    }
}
