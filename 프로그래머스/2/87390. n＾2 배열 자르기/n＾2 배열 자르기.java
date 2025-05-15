class Solution {
    public long[] solution(int n, long left, long right) {
        // long[][] board = new int[n][n];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         board[i][j] = Math.max(i+1, j+1);
        //     }
        // }
        
        long[] answer = new long[(int)(right-left)+1];
        
        int idx = 0;
        
        for(long i=left; i<=right; i++){
            long y = i/n;
            long x = i%n;
            
            // answer[idx++] = board[y][x];
            
            answer[idx++] = Math.max(y+1, x+1);
        }
        return answer;
    }
    
//     1 2 3 
//     2 2 3
//     3 3 3
        
//     123223333
}