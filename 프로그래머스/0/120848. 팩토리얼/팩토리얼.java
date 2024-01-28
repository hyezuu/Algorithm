class Solution {
    public int solution(int n) {
        int i = 0;
        int answer = 1;
        while(answer<=n){
            i++;
            answer*=i;
        }
        return i-1;
    }
}