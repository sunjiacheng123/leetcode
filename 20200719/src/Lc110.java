
class TreeNode {
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
