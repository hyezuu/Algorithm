import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map = new HashMap<>();
         int[] emergency1 = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(emergency);
        for(Integer i=0; i<emergency.length; i++){
            map.put(Integer.valueOf(emergency[i]), emergency.length-i);
        }
        for(int i=0; i<emergency.length; i++){
            emergency1[i] = map.get(emergency1[i]);
        }
        return emergency1;
    }
}