class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n%2==0){
            for(int i=2; i<=n ;i++){
                if(i%2==0) answer+=Math.pow(i,2);
            }
        }
        else for(int i=1; i<=n ;i++){
            if(i%2!=0) answer+=i;
        }
        return answer;
    }
}