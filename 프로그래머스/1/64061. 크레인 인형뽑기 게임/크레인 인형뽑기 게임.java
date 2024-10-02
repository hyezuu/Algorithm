import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int len = board.length;
        int answer = 0;
        for(int m : moves){
            for(int i=0; i<len; i++){
                if(board[i][m-1]!=0){
                    int tmp = board[i][m-1];
                    board[i][m-1]=0;
                    if(!stack.isEmpty() && stack.peek()==tmp){
                        stack.pop();
                        answer+=2;
                    }
                    else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }
}