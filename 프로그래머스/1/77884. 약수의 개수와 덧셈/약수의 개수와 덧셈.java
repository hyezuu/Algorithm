class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            answer += i * (isPerfectSqrt(i) ? -1 : +1);
        }
        return answer;
    }
    
    static boolean isPerfectSqrt(int num){
        int sqrt = (int)Math.sqrt(num);
        
        return sqrt * sqrt == num;
    }
}