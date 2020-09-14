# leetcode--2.两数相加

**题目**：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。[leetcode链接](https://leetcode-cn.com/problems/add-two-numbers/)

1. 将当前结点初始化为返回列表的哑结点。

2. 将进位 carry 初始化为 0。

3. 将 p 和 q分别初始化为列表 l1 和 l2 的头部。

4. 遍历列表 l1l1l1 和 l2l2l2 直至到达它们的尾端。

   - 将 x设为结点 p 的值。如果 p 已经到达 l1的末尾，则将其值设置为 0。
   - 将 y 设为结点 q 的值。如果 q 已经到达 l2的末尾，则将其值设置为 0。
   - 设定 sum=x+y+carry。
   - 更新进位的值，carry=sum/10。
   - 创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
   - 同时，将 p 和 q前进到下一个结点。

   5.检查 carry=1是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。

   6.返回哑结点的下一个结点。

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode lis=new ListNode(0);
    ListNode cur= lis,p=l1,q=l2;
    int carry=0;
    while (p!=null || q!=null){
        int x=(p!=null)?p.val:0;
        int y=(q!=null)?q.val:0;
        int sum= x + y + carry;
        carry = sum / 10;
        cur.next=new ListNode(sum % 10);
        cur=cur.next;
        if(p!=null)p=p.next;
        if(q!=null)q=q.next;
    }
    if(carry>0){
        cur.next=new ListNode(carry);
    turn lis.next;
}
```

# leetcode--19.删除链表的倒数第N个点

**题目**：给定一个链表，删除链表的倒数第 *n* 个节点，并且返回链表的头结点。

[leetcode链接](https://leetcode-cn.com/problems/add-two-numbers/)

要建立辅助节点，不然会出现异常！！

```java
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
```