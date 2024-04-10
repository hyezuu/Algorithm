class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int r = (int)Math.sqrt(i);
            answer+= i * (r*r==i? -1 : 1);
        }
        return answer;
    }
}