class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        
        for(int i=1; i<=number; i++){
            int cnt = 0;
            for(int j=1; j<=Math.sqrt(i); j++){
                if(j*j==i) cnt++;
                else if(i%j==0) cnt+=2;
                
                if(cnt>limit){
                    cnt = power;
                    break;
                }
            }
            sum+=cnt;
        }
        return sum;
    }
}