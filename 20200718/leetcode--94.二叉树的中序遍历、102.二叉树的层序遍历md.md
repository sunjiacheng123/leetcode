# leetcode--94.二叉树的中序遍历

**题目**：给定一个二叉树，返回它的*中序* 遍历

[leetcode链接](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

**代码：**

方法一：递归

```java

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lis=new ArrayList<>();
        func(root,lis);
        return lis;
    }

    private void func(TreeNode root, List<Integer> lis) {
         if(root!=null){
             func(root.left,lis);
             lis.add(root.val);
             func(root.right,lis);
         }
    }
```

方法二：使用栈的特性

```java
    public List<Integer> inorderTraversal(TreeNode root){
         List<Integer> lis=new ArrayList<>();
         if(root==null){
             return lis;
         }
         TreeNode cur=root;
         Stack<TreeNode> s=new Stack<>();
         while (!s.empty() || cur!=null){
             while(cur!=null){
                 s.push(cur);
                 cur=cur.left;
             }
             cur=s.pop();
             lis.add(cur.val);
             cur=cur.right;
         }
         return lis;
     }
```

# leetcode--102.二叉树的层序遍历

**题目**：给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。

[leetcode链接](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>> ret=new ArrayList<>();
        if(null==root){
            return ret;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            //队列中保存的就是一层的额节点
            //一次性将该层的节点全部遍历完
            int size=q.size();
            List<Integer> lis=new ArrayList<>(q.size());
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
                lis.add(cur.val);
            }
            ret.add(lis);
        }
        return ret;
    }
}
```

