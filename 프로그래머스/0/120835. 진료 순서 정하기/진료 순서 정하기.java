import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] emergency1 = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(emergency);
        for(Integer i=0; i<emergency.length; i++){
            map.put(Integer.valueOf(emergency[i]), emergency.length-i);
        }
        
        return Arrays.stream(emergency1).map(c-> map.get(c)).toArray();
    }
}