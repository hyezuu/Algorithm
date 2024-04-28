class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            answer += (n/a)*b;
            n = (int)(n/a)*b + n%a;
        }
        return answer;
    }
}