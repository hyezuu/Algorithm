import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] com : commands){
            int len = com[1]-com[0]+1;
            int[] copy = new int[len];
            System.arraycopy(array, com[0]-1, copy, 0, len);
            Arrays.sort(copy);
            answer[idx++] = copy[com[2]-1];
        }
        return answer;
    }
}