class Solution {
    public int solution(int n) {
        int cnt = n<=2 ? 0 : 1; 
        int sum = 0, lt = 1;
        int m = n/2 + 1;
        
        for(int rt = 1; rt <=m ; rt++){
            sum+=rt;
            if(sum==n)cnt++;
            while(sum>=n){
                sum-=lt++;
                if(sum==n) cnt++;
            }
        }
        return cnt;
    }
}