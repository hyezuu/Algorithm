import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        for(String x : my_string.split("\\s+")){
            if(!x.isEmpty()){
                list.add(x);
            }
        }
        return list.toArray(new String[0]);
    }
}