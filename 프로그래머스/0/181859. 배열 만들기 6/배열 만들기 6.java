import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        for(int a : arr){
            if(!stack.isEmpty()&& stack.peek()==a) stack.pop();
            else stack.push(a);
            i++;
        }
        if(stack.isEmpty()) return new int[]{-1};
        else {
            int[] answer = new int[stack.size()];
            int idx = 0;
            for(int k : stack){
                answer[idx++] = k;
            }
            return answer;
        }
    }
}