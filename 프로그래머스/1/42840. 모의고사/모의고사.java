import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(p1[i%p1.length]==answers[i]) s1++;
            if(p2[i%p2.length]==answers[i]) s2++;
            if(p3[i%p3.length]==answers[i]) s3++;
        }
        
        map.put(s1, new ArrayList<>(Arrays.asList(1)));
        map.put(s2, map.getOrDefault(s2, new ArrayList<>()));
        map.get(s2).add(2);
        map.put(s3, map.getOrDefault(s3, new ArrayList<>()));
        map.get(s3).add(3);
        
        int max = Math.max(s1, Math.max(s2,s3));
        int size = map.get(max).size();
        int idx = 0;
        
        int[] answer = new int[size];
        for(int a : map.get(max)){
            answer[idx++] = a;
        }
        
        return answer;
    }
}