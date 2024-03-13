class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0,evenSum = 0;
        for(int i=1; i<=num_list.length; i++){
            if(i%2!=0){
                oddSum+=num_list[i-1];
            }
            else evenSum+=num_list[i-1];
        }
        return Math.max(oddSum,evenSum);
    }
}