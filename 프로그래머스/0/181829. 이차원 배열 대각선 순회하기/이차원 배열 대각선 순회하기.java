class Solution {
    public int solution(int[][] board, int k) {
        int lenI = Math.min(board.length-1,k);
        int lenJ = Math.min(board[0].length-1,k);
        int answer = 0;
        for(int i=0; i<=lenI; i++){
            for(int j=0; j<=lenJ; j++){
                if(i+j<=k){
                    answer+=board[i][j];
                }
            }
        }
        return answer;  
    }
}