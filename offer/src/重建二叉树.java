class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class 重建二叉树 {
    static int index=0;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=func(pre,in, 0,pre.length );
        return root;
    }

    private TreeNode func(int[] pre, int[] in, int left, int right) {
        if(left>=right && index>= pre.length){
            return null;
        }
        TreeNode node=new TreeNode(pre[index]);
        int newindex=left;
        while (newindex<right){
            if(pre[index]==in[newindex]){
                break;
            }
            newindex++;
        }
        index++;
        node.left=func(pre,in,left,newindex);
        node.right=func(pre,in,newindex+1,right);
        return node;
    }

}
