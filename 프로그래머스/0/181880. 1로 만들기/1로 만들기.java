class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int a : num_list){
            while(a>1){
                a=  a>>1;
                answer++;
            }
           // answer += Integer.toBinaryString(a).length()-1;
        }
        return answer;
    }
}