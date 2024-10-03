import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            int tmp = choices[i];
            if(tmp==4) continue;
            char type = survey[i].charAt(tmp/4);
            int point = tmp/4 == 0 ? 4-(tmp%4) : tmp%4;
            map.put(type, map.getOrDefault(type,0)+point);
        }
        StringBuilder sb = new StringBuilder();
        
        String[] types = {"RT", "CF", "JM", "AN"};
        
        for(String t : types){
            int type1 = map.getOrDefault((t.charAt(0)),0);
            int type2 = map.getOrDefault((t.charAt(1)),0);
            
            if(type1 >= type2) sb.append(t.charAt(0));
            else sb.append(t.charAt(1));
        }
        return sb.toString();
    }
}