import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cl94 {
     public class TreeNode {
         int val;TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

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
}
