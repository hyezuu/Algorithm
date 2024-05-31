import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<my_string.length(); i++){
            list.add(my_string.substring(i));
        }
        Collections.sort(list);
        
        return list.stream().toArray(String[]::new);
        
        
        
        
        
        // String[] answer = new String[my_string.length()];
        // for(int i=0; i<my_string.length(); i++){
        //     answer[i]=my_string.substring(i,my_string.length());
        // }
        // Arrays.sort(answer);
        // return answer;
    }
}