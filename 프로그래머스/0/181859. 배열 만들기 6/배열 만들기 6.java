import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>(); 
        
        for(int a : arr){
            if(!stack.isEmpty()&& stack.peek()==a) stack.pop();
            else stack.push(a);
        }
        
        return stack.isEmpty()? new int[]{-1} : stack.stream().mapToInt(i->i).toArray();
    }
}