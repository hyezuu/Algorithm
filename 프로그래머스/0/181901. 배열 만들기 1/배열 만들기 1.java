class Solution {
    public int[] solution(int n, int k) {
        int i=1, m=1;
        int[] answer = new int[n/k];
        while(i*k<=n){
            answer[i-1]=i*k;
            i++;
        }
        return answer;
    }
}