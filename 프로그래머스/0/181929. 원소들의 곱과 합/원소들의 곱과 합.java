class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int multi = 1;
        for(int a : num_list){
            sum+=a;
            multi*=a;
        }
        return Math.pow(sum,2)>multi?1:0;
    }
}