import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = myStr.split("[a-c]");
        List<String> list = new ArrayList<>();
        for(String s : arr){
            if(!s.isEmpty()) list.add(s);
        }
        if(arr.length==0) return new String[] {"EMPTY"};
        else return list.toArray(new String[0]);
    }
}