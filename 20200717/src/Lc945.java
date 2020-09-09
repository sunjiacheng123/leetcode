public class Lc945 {
    public int minIncrementForUnique(int[] A) {
        int[] count=new int[8000];
        for(int i=0;i<A.length;i++){
            count[A[i]]++;
        }
        //num；重复的个数
        int sum=0,num=0;
        for(int i=0;i<8000;i++){
            if(count[i]>=2){
                num+=count[i]-1;
                sum-=i*(count[i]-1);
            }else if(num>0 && count[i]==0){
                num--;
                sum+=i;
            }
        }
        return sum;
    }
}
