

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc145 {

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> helper = new Stack<TreeNode>();
        TreeNode current = root, r = null;  //r结点用来区分之前的结点是否被访问过
        while(current != null || !helper.isEmpty()){
            if(current != null){    //到树的最左面
                helper.push(current);
                current = current.left;
            }else{
                current = helper.peek();    //看最左结点有没有右子树
                if(current.right != null && current.right != r){
                    current = current.right;
                    //helper.push(current);
                    //current = current.left;     //右子树再到最左
                }else{
                    current = helper.pop();    //访问该结点，并标记被访问
                    ans.add(current.val);
                    r = current;
                    current = null;
                }
            }
        }
        return ans;
    }
}
