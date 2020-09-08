import java.util.ArrayList;
import java.util.List;
/*
螺旋矩阵：

 */
public class Lc54 {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0){
            return list;
        }
        //i;行数  j；列数
        int left=0,right=matrix[0].length-1;
        int top=0,bottm=matrix.length-1;

        while (left<=right && top<=bottm){
            //左--右
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            //上--下
            for(int j=top+1;j<=bottm;j++){
                list.add(matrix[j][right]);
            }
            if(left<right && top<bottm){
                for(int i=right-1;i>=left;i--){
                    list.add(matrix[bottm][i]);
                }
                for(int j=bottm-1;j>top;j--){
                    list.add(matrix[j][left]);
                }
            }
            left++;
            right--;
            top++;
            bottm--;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
