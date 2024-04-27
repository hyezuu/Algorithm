import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char tmp = words[0].charAt(0);
        Set<String> set = new HashSet<>();
        for(int i=0; i<words.length; i++){
            if(words[i].charAt(0)!=tmp||!set.add(words[i])){
                answer[0] = i%n + 1;
                answer[1] = (int)i/n + 1;
                return answer;
            }
            tmp = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}