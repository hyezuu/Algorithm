import java.util.*;

class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    public void dfs (int[] numbers, int target, int idx, int cur){
        if(idx==numbers.length){
            if(cur==target) count++;
            return;
        }
        
        dfs(numbers, target, idx+1, cur+numbers[idx]);
        dfs(numbers, target, idx+1, cur-numbers[idx]);
    }
}