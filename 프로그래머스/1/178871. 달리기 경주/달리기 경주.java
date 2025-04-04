import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rate = new HashMap<>();
        Map<String, Integer> member = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            rate.put(i+1, players[i]);
            member.put(players[i], i+1);
        }
        
        for(String calling : callings){
            int current = member.get(calling);
            String previous = rate.get(current-1);
            
            rate.put(current-1, calling);
            member.put(calling, current-1);
            rate.put(current, previous);
            member.put(previous, current);
        }
        
        String[] answer = new String[players.length];
        
        for(int i=1; i<=players.length; i++){
            answer[i-1] = rate.get(i);
        }
        
        return answer;
    }
}