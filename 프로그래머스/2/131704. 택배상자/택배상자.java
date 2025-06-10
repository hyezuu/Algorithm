import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int curBox = 1;
        int cnt = 0;
        for(int box : order){
            //빼야하는 상자가 더 큰 경우
            while(box >= curBox){
                //보조컨테이너에 넣음
                stack.push(curBox++);
            }
            if(!stack.isEmpty() && stack.peek() == box){
                stack.pop();
                cnt++;
            }
            else return cnt;
        }
        
        return cnt;
    }
}