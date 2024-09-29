import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {    
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        initMap(str1, map1);
        initMap(str2, map2);
    
        int uc = 0;
        int ic = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                ic+=Math.min(map1.get(key), map2.get(key));
                uc+=Math.max(map1.get(key), map2.get(key));
            }
            else uc+=map1.get(key);
        }
        for(String key : map2.keySet()){
            if(!map1.containsKey(key)){
                uc+=map2.get(key);
            }
        }
        
        
        return uc == 0 ? 65536 : (int)(((double)ic/uc*65536));
    }
    private boolean isMatch(String str){
        return Pattern.matches("^[a-z]+$",str);
    }
    private void initMap(String str, Map<String, Integer> map){
        for(int i=0; i<str.length()-1; i++){
            String tmp = str.substring(i,i+2);
            if(isMatch(tmp)) {
                map.put(tmp, map.getOrDefault(tmp, 0)+1);
            }
        }
    }
}