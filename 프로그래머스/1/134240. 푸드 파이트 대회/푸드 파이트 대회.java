class Solution {
    public String solution(int[] food) {
        String answer = "0";
        
        for(int i=food.length-1; i>=0; i--){
            int tmp = food[i]/2;
            if(tmp > 0){
                answer = (i+"").repeat(tmp) + answer + (i+"").repeat(tmp);
            }
        }
        
        return answer;
    }
}