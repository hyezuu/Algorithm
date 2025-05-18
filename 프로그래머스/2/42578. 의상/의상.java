import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] c : clothes){
            String category = c[1];
            map.put(category, map.getOrDefault(category, 0)+1);
        }
        
        int total = 1;
        
        for(String category : map.keySet()){
            total *= (map.get(category)+1);
        }
        
        return total-1;
    }
}