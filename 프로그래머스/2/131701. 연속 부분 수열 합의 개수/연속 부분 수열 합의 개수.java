import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] arr = new int[elements.length*2];
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            arr[i] = elements[i];
            arr[elements.length+i] = elements[i];
            set.add(arr[i]);
        }
    
        
        int[] tmp = new int[elements.length];
        
        for(int i=0; i<elements.length; i++){
            tmp[i] = elements[i];
            for(int j=1; j<elements.length; j++){
                tmp[i] += arr[i+j];
                set.add(tmp[i]);
            }
        }
        return set.size();
    }
}