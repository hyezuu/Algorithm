import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int idx = 0;
        String s = "";
        
        for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l")|| str_list[i].equals("r")){
                idx = i;
                s = str_list[i];
                break;
            }
        }
        
        if(s.equals("r")) return Arrays.copyOfRange(str_list,idx+1,str_list.length);
        else return Arrays.copyOfRange(str_list,0,idx);
    }
}