class Solution {
    public int solution(int[] num_list) {
        int answer = 1;
        if(num_list.length>=11){
            answer = 0;
            for(int a : num_list){
                answer+=a;
            }
        }
        else 
            for(int a : num_list){
                answer*=a;
            }
        return answer;
    }
}