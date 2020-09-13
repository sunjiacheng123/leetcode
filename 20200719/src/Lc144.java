import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc144 {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> lis=new ArrayList<>();
//        if(root==null){
//            return lis;
//        }
//        func(lis,root);
//        return lis;
//    }
//
//    private void func(List<Integer> lis, TreeNode root) {
//        if(root!=null){
//            lis.add(root.val);
//            func(lis,root.left);
//            func(lis,root.right);
//        }
//
//    }
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
}
