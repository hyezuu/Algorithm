class Solution {
    public int solution(int[][] board) {
        int length = board.length;
        
        int[] aroundX = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] aroundY = {1, 1, 1, 0, 0, 0, -1, -1, -1};   
         
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(board[i][j] == 1){
                    board[i][j] = 2;
                    for(int k=0; k<9; k++){
                        int x = i+aroundX[k] ;
                        int y = j+aroundY[k] ;
                        if(x>=0 && x<length && y>=0 && y<length &&board[x][y]!=1){
                            board[x][y] = 2;
                        }
                    }
                }
            }
        }
        int count = 0;
        
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(board[i][j]!=2){
                    count++;
                }
            }
        }
        return count;
    }
}