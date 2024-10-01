import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> usernameMap = new HashMap<>();
        Queue<String[]> q = new LinkedList<>();
        for(String record : records){
            String[] tmp = record.split(" ");
        
            if(!tmp[0].equals("Leave")){
                usernameMap.put(tmp[1], tmp[2]);
            }
            if(!tmp[0].equals("Change")){
                String msg = tmp[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
                q.offer(new String[]{msg, tmp[1]});
            }
        }

        String[] answer = new String[q.size()];
        int idx = 0;
        
        while(!q.isEmpty()){
            String[] poll = q.poll();
            answer[idx++] = usernameMap.get(poll[1]) + poll[0];
        }
        return answer;
    }
}