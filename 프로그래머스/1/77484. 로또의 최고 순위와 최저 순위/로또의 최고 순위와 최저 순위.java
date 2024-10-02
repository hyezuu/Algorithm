class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0;
        int zero = 0;
        
        int[] nums = new int[46];
        
        for(int i : win_nums){
            nums[i]++;
        }
        
        for(int i : lottos){
            if(i==0) zero++;
            else if(nums[i]>0) correct++;
        }
        
        return new int[]{Math.min(7-(correct+zero),6), Math.min((7-correct), 6)};
    }
}