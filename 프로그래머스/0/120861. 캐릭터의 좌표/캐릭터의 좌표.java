import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int maxX = (board[0]-1)/2;
        int maxY = (board[1]-1)/2;
        Map<String, List<Integer>> move = new HashMap<>();
        
        move.put("left",Arrays.asList(-1,0));
        move.put("right",Arrays.asList(1,0));
        move.put("up",Arrays.asList(0,1));
        move.put("down",Arrays.asList(0,-1));
            
        for(String key : keyinput){  
            answer[0] += move.get(key).get(0);
            answer[1] += move.get(key).get(1);
            if(Math.abs(answer[0])>maxX ||Math.abs(answer[1])>maxY){
                answer[0] -= move.get(key).get(0);
                answer[1] -= move.get(key).get(1);
            }
        }
        return answer;
    }
}