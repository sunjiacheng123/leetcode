import java.util.ArrayList;
import java.util.List;

public class Lc73 {
    public static void setZeroes(int[][] matrix) {
        List <ArrayList<Integer>> list=new ArrayList<>();
        int[][] arr=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            arr[i]=matrix[i].clone();
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(arr[i][j]==0){

                    func(matrix,i,j);
                }
            }
        }
    }

    public static void func(int[][] matrix,int i,int j){
        for(int m=0;m<matrix.length;m++){
            matrix[m][j]=0;

        }
        for(int m=0;m<matrix[0].length;m++){
            matrix[i][m]=0;
        }
    }
    public static void main(String[] args) {
        int[][] matrix={{0,1}};
        setZeroes(matrix);

    }
}
