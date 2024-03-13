import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<todo_list.length; i++){
            sb.append(finished[i]?"":todo_list[i]+",");
        }
            
        return sb.toString().split(",");
    }
}