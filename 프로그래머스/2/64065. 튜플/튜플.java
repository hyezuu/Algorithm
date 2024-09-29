import java.util.*;

class Solution {
    public int[] solution(String s) {
        PriorityQueue<List<Integer>> q = new PriorityQueue<>(Comparator.comparingInt(List::size));
        List<Integer> comp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i=1;
        while(i<s.length()-1){
            if(s.charAt(i)=='{'||s.charAt(i)==','){
                while(Character.isDigit(s.charAt(++i))){
                    sb.append(s.charAt(i));
                }
                if(sb.length()>0){
                    comp.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
            }
            else if(s.charAt(i++)=='}'){
                q.offer(comp);
                comp = new ArrayList<>();
            }
        }
        Set<Integer> set = new LinkedHashSet<>();
        while(!q.isEmpty()){
            List<Integer> tmp = q.poll();
            
            for(int num : tmp){
                set.add(num);
            }
        }
        
        int[] answer = new int[set.size()];
        i=0;
        for(int num : set){
            answer[i++] = num;
        }
        
        return answer;
    }
}