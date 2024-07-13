import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        int box = 1;
        for(int i : order){
            while(box<=i){
                stack.push(box++);
            }
            if(stack.pop()==i){
                cnt++;
            }
            else break;
        }
        return cnt;
    }
}