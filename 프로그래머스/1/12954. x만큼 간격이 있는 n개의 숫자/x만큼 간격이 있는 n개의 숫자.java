class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        while(idx<n){
            answer[idx] = x*(1+idx++);
        }
        return answer;
    }
}