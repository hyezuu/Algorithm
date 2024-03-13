import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int cnt=0;
        List<Integer> list = new ArrayList<>();
        for(char c :myString.toCharArray()){
            if(c=='x'){
                list.add(cnt);
                cnt=0;
            }
            else cnt++;
        }
        list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}