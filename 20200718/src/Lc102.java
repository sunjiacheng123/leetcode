import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
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
