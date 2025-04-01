import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        
        String[] cases = {"RT" ,"CF", "JM", "AN"};
        
        for(String c : cases){
            map.put(c.charAt(0), 0);
            map.put(c.charAt(1), 0);
        }
        
        for(int i=0; i<survey.length; i++){
            if(choices[i] < 4){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) +4-choices[i]);
            }
            else map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+choices[i]-4);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String cs : cases){
            if(map.get(cs.charAt(0)) >= map.get(cs.charAt(1))){
                sb.append(cs.charAt(0));
            }
            else sb.append(cs.charAt(1));
        }
        
        return sb.toString();
    }
}