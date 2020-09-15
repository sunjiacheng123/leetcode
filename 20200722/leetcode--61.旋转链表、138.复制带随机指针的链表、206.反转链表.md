# leetcode--61.旋转链表

**题目**：给定一个链表，旋转链表，将链表每个节点向右移动 *k* 个位置，其中 *k* 是非负数。

[leetcode链接](https://leetcode-cn.com/problems/rotate-list/)

- 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
- 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
- 断开环 new_tail.next = None，并返回新的链表头 new_head。

```java
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
```

# leetcode--138.复制带随机指针的链表

**题目**:给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 **深拷贝**。 

我们用一个由 `n` 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 `[val, random_index]` 表示：

- `val`：一个表示 `Node.val` 的整数。
- `random_index`：随机指针指向的节点索引（范围从 `0` 到 `n-1`）；如果不指向任何节点，则为  `null` 。





[leetcode链接](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

**①建立老节点新节点交替的链表。
②循环解决random指针问题：老节点.next.random=老节点.random.next
③.拆分链表。cur–>需要拆开的节点。**

**代码：**

```java
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
```

# leetcode--206.反转链表

**题目**：反转一个单链表。

[leetcode链接](https://leetcode-cn.com/problems/reverse-linked-list/)

**方法一：**

将链表中的每一节点当成单独节点，使用头插法插入节点，实现逆置。

**方法二：**

```java
public ListNode reverseList(ListNode head) {
    ListNode pre=null;
    ListNode cur=head;
    ListNode newHead=null;
    while (cur!=null){
        ListNode curNext=cur.next;
        if(curNext==null){
            newHead=cur;
        }
        cur.next=pre;
        pre=cur;
        cur=curNext
    }
    return newHead;
}
```













