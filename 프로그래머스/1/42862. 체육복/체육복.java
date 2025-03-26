class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] total = new int[n+2];
        for(int i=1; i<=n; i++){
            total[i] = 1;
        }
        
        for(int l : lost){
            total[l]--;
        }
        
        for(int r : reserve){
            total[r]++;
        }
        
        for(int i=1; i<=n; i++){
            if(total[i]==0){
                if(total[i-1]>1){
                    total[i-1]--;
                    total[i]++;
                }
                else if(total[i+1]>1){
                    total[i+1]--;
                    total[i]++;
                }
            }
        }
        
        int cnt = 0;

        for(int i=1; i<=n; i++){
            if(total[i]>0) cnt++;
        }
        return cnt;
    }
}