import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {    
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++){
            String tmp = str1.substring(i,i+2);
            if(isMatch(tmp)) {
                map1.put(tmp, map1.getOrDefault(tmp, 0)+1);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            String tmp = str2.substring(i,i+2);
            if(isMatch(tmp)) {
                map2.put(tmp, map2.getOrDefault(tmp, 0)+1);
            }
        }
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
    public static boolean isMatch(String str){
        return Pattern.matches("^[a-z]+$",str);
    }
}