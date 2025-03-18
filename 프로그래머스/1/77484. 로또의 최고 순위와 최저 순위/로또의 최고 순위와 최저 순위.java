import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n : win_nums){
            set.add(n);
        }
        
        int wildcard = 0;
        int correct = 0;
        
        for(int i : lottos){
            if(i == 0) {
                wildcard ++ ;
            }
            
            if(set.contains(i)) correct ++;
        }
        
        int high = Math.min(7 - (wildcard + correct), 6);
        int low = Math.min(7-correct, 6);
        
        return new int[]{high, low};
    }
}