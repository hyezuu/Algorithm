class Solution {
    public long solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int[] linkedArr = new int[len*2];
        long sum1 = 0, sum2 = 0;
        
        for(int i=0; i<len; i++){
            linkedArr[i] = queue1[i];
            linkedArr[i+len] = queue2[i];
            sum1+=queue1[i];
            sum2+=queue2[i];
        }
        
        if((sum1+sum2)%2!=0) return -1;
        
        int lt = 0;
        int rt = len;
        long cnt = 0;
        while(lt<rt){
            if(sum1==sum2) return cnt;
            if(rt==(len*2)) return -1;
            if(sum1<sum2){
                sum1 += linkedArr[rt];
                sum2 -= linkedArr[rt];
                rt++;
            }
            else {
                sum1 -= linkedArr[lt];
                sum2 += linkedArr[lt];
                lt++;
            }
            cnt++;
        }
        return lt==rt ? -1 : cnt;
    }
}