import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(String term : terms){
            String[] tmp = term.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        
        int todays = getDate(today);
        
        for(int i=0; i<privacies.length; i++){
            String[] tmp = privacies[i].split(" ");
            
            int days = getDate(tmp[0])+map.get(tmp[1])*28;
            if(todays >= days){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int getDate(String strDate){
        int[] multi = {28*12, 28, 1};
        String[] split = strDate.split("\\.");
        int answer = 0;
        for(int i=0; i<3; i++){
            answer+=Integer.parseInt(split[i])*multi[i];
        }
        return answer;
    }
}