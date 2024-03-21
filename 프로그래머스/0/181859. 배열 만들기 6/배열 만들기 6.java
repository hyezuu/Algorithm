import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        while(i<arr.length){
            if(!stack.isEmpty()&& stack.peek().equals(arr[i])) stack.pop();
            else stack.push(arr[i]);
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