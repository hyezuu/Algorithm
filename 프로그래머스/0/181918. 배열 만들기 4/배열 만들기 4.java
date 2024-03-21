import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i<arr.length){
            if(stack.isEmpty()) stack.push(arr[i++]);
            else {
                if(stack.peek()<arr[i]) stack.push(arr[i++]);
                else stack.pop();
            }
        }
        int[] stk = new int[stack.size()];
        int idx = 0;
        for(int k : stack){
            stk[idx++] = k;
        }
        return stk;
    }
}