import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] spell, String[] dic) {
        String[][] strArr = Arrays.stream(dic)
            .map(c-> c.split(""))
            .toArray(String[][]::new);
        
        for(int i=0; i<dic.length; i++){
            Arrays.sort(strArr[i]);
            dic[i] = String.join(",",strArr[i]).trim();
        }
         
        Arrays.sort(spell);
        
       for(String str : dic){
           if(str.equals(String.join(",",spell))){
               return 1;
           }           
       }
       return 2;
    }
} 