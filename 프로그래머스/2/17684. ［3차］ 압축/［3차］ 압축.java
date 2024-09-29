import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(char c='A'; c<='Z'; c++){
            map.put(String.valueOf(c), c-'A'+1);
        }
        
        int idx = 0;
        int last = 27;
        List<Integer> list = new ArrayList<>();
        
        while(idx<msg.length()){
            
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(idx));
            int tmp = -1;
            
            while(idx<msg.length() && map.containsKey(sb.toString())){
                tmp = map.get(sb.toString());
                if(idx+1<msg.length()){
                    sb.append(msg.charAt(++idx));
                } else {
                    idx++;
                    break;
                }
            }
            map.put(sb.toString(), last++);
            list.add(tmp);
        }
        
        int[] answer = new int[list.size()];
        
        idx = 0;
        
        for(int a : list){
            answer[idx++] = a;
        }
        
        return answer;
    }
}