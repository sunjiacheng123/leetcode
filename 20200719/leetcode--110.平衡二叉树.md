# leetcode--110.平衡二叉树

**题目**：给定一个二叉树，判断它是否是高度平衡的二叉树。

[leetcode链接](https://leetcode-cn.com/problems/balanced-binary-tree/submissions/)



**代码：**

```java
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

public class Lc110 {
    public int getheight(TreeNode root){
        if(null==root){
            return 0;
        }
        int left=getheight(root.left);
        int right=getheight(root.right);
        return left>right?left+1:right+1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left=getheight(root.left);
        int right=getheight(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

}
```

# leetcode--144.前序遍历

**题目：**给定一个二叉树，返回它的 *前序* 遍历

[leetcode链接](https://leetcode-cn.com/problems/balanced-binary-tree/submissions/)

**代码：**

方法一：递归

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> lis=new ArrayList<>();
    if(root==null){
        return lis;
    }
    func(lis,root);
    return lis;
}

private void func(List<Integer> lis, TreeNode root) {
    if(root!=null){
        lis.add(root.val);
        func(lis,root.left);
        func(lis,root.right);
    }

}
```

方法二：使用栈

```java
public List<Integer> preorderTraversal(TreeNode root){
    List<Integer> lis=new ArrayList<>();
    Stack<TreeNode> s=new Stack<>();
    s.add(root);
    while (!s.empty()){
        TreeNode cur=s.peek();
        lis.add(cur.val);
        s.pop();
        if(cur.right!=null){
            s.add(cur.right);
        }
        if(cur.left!=null){
            s.add(cur.left);
        }
    }
    return lis;
}
```

# leetcode--145.后序遍历

**题目：**给定一个二叉树，返回它的 *后序* 遍历

[leetcode链接](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

代码：

1. 找到二叉树最左侧的节点，并保存所经路径上的所有节点
2. top获取栈顶元素--获取根节点
3. 遍历top右子树

```java
public List<Integer> postorderTraversal(TreeNode root) {
     TreeNode tre=null;
     TreeNode cur=root;
     List<Integer> lis=new ArrayList<>();
     Stack<TreeNode> s=new Stack<>();
     while (cur!=null ||!s.empty()){
         if(cur!=null){
             s.push(cur);
             cur=cur.left;
         }else{
             TreeNode top=s.peek();
             if(top.right==null || tre==top.right){
                 s.pop();
                 lis.add(top.val);
                 tre=top;

             }else {
                 cur=top.right;
                 s.push(cur);
                 cur=cur.left;
             }
         }
     }
     return lis;
}
```