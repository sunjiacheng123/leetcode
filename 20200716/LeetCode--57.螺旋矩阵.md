# LeetCode--57.螺旋矩阵

**题目：**给定一个包含 *m* x *n* 个元素的矩阵（*m* 行, *n* 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

可以将矩阵看成若千层，首先输出最外层的元素，其欺输出次外层的元素，直到输出最内层的元素。

[网址链接](https://leetcode-cn.com/problems/spiral-matrix/)

1. 从左到右遍历上侧元素，依次为 (top,left) 到(top,right)。
2. 从上到下遍历右侧元素,依次为(top + 1, right)到(bottom, right)。
3. 如果left < right且top < bottom, 则从右到左遍历下侧元素，依次为(bottom, right- 1)到(bottom, left + 1),以及从下到上遍历左侧元素,依次为(bottom, left)到(top + 1, left)。

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
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
}
```

