class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            int k = signs[i] ? absolutes[i] : absolutes[i]*(-1);
            
            answer+=k;
        }
        return answer;
    }
}