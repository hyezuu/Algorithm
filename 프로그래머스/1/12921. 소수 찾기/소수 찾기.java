class Solution {
    public int solution(int n) {
        
        boolean[] check = new boolean[n+1];
        
        int cnt = 0;
        
        for(int i=2; i<=n; i++){
            if(!check[i]){
                for(int j=i; j<=n; j+=i){
                    check[j] = true;
                }
                cnt++;
            }
        }
        return cnt;
    }
}