import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        int size = 0;
 
        for(int i=0; i<lines.length; i++){
            for(int j=lines[i][0]; j<lines[i][1]; j++){               
                if(!set.add(j)){
                    size++;
                    if(!set1.add(j)){
                        size--;
                    }
                }                
            }
        }
        return size;
    }
}