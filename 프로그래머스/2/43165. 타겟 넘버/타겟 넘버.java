class Solution {
    static int count;
    static int t;
    static int[] nums;
    public int solution(int[] numbers, int target) {
        count = 0;
        t = target;
        nums = numbers;
        
        dfs(0, 0);
        return count;
    }
    
    static void dfs(int i, int total){
        if(i==nums.length){
            if(total == t) count++;
            return;
        }
        dfs(i+1, total+nums[i]);
        dfs(i+1, total-nums[i]);
    }
}