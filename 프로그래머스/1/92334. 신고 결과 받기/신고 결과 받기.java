import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new LinkedHashMap<>();
        
        Map<String, Integer> reportedCount = new HashMap<>();
        
        for(String id : id_list){
            map.put(id, new HashSet<String>());
            reportedCount.put(id, 0);
        }
        
        for(String r : report){
            String[] temp = r.split(" ");
            if(map.get(temp[0]).add(temp[1])){
                reportedCount.put(temp[1], reportedCount.get(temp[1])+1);
            }
        }
        
        int[] answer = new int[id_list.length];
        int idx = 0;
        for(String key : map.keySet()){
            Set<String> set = map.get(key);
            int count = 0;
            for(String s : set){
                if(reportedCount.get(s) >= k) count++;
            }
            answer[idx++] = count;
        }
        
        return answer;

    }
}