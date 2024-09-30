import java.util.*;

class Solution {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : dartResult.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
                continue;
            }
            if(sb.length() > 0){
                stack.push(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            if(c=='S' || c=='D' || c=='T'){
                int point = stack.pop();
                int bonus = c== 'S' ? 1 : (c =='D' ? 2 : 3);
                stack.push((int)Math.pow(point, bonus));
            }
            if(c=='*'|| c=='#') {
                int tmp = stack.pop();
                int opt = -1;
                if(c =='*'){
                    opt = 2;
                    if(!stack.isEmpty()) stack.push(stack.pop()*opt);     
                }
                stack.push(tmp*opt);
            }
        }
        int answer = 0;
        
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        
        return answer;
    }
}