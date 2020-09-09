# LeetCode--73.矩阵置零

[LeetCode链接](https://leetcode-cn.com/problems/set-matrix-zeroes/)

**题目**：给定一个 *m* x *n* 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用**原地**算法**。**

1. 先将原先二维数组拷贝为arr[][]
2. 循环判断arr中每个位置是否为0：为零则调用func（）函数，并传入matrix数组和当前位置的坐标i、j
3. func（）函数：循环将传入的第i行、第j列置为0

**代码：**

```java
class Solution {
    public void setZeroes(int[][] matrix) {
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
    public  void func(int[][] matrix,int i,int j){
        for(int m=0;m<matrix.length;m++){
            matrix[m][j]=0;
            //matrix[i][m]=0;
        }
        for(int m=0;m<matrix[0].length;m++){
            matrix[i][m]=0;
        }
    }
}
```

# LeetCode--945.使数组唯一的最小增量

**题目**：给定整数数组 A，每次 *move* 操作将会选择任意 `A[i]`，并将其递增 `1`。返回使 `A` 中的每个值都是唯一的最少操作次数。

[LeetCode链接](https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/)

- 以 [1, 1, 1, 1, 3, 5] 为例，当我们发现有 3 个重复的 1 时，我们先将操作次数减去 1 + 1 + 1。
  1. count[A[i]]++：count中存放A[i]的个数
  2. count[i]>=2时：num保存重复的个数
- 接下来，当我们发现 2，4 和 6 都没有出现过时，我们依次将操作次数增加 2，4 和 6

**总结**：数组中每个没有数值的点相加，减去每个点重复的次数*点的值

**代码：**



```java
class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count=new int[80000];
        for(int i=0;i<A.length;i++){
            count[A[i]]++;
        }
        //num；重复的个数
        int sum=0,num=0;
        for(int i=0;i<80000;i++){
            if(count[i]>=2){
                num+=count[i]-1;
                sum-=i*(count[i]-1);
                //count[i]==0：表示A中没有等于i的值
                //num>0：有重复的个数
            }else if(num>0 && count[i]==0){
                num--;
                sum+=i;
            }
        }
        return sum;
    }
}
```

