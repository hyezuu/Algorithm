class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length; 
        int m = board[0].length;
        int[][] sum = new int[n+1][m+1];
        
        for(int i=0; i<skill.length; i++){
            int type = skill[i][0] == 1 ? -1 : 1;
            int r1 = skill[i][1], r2 = skill[i][3], c1 = skill[i][2], c2 = skill[i][4];
            int degree = skill[i][5] * type;
            
            sum[r1][c1] += degree;
            sum[r1][c2+1] -= degree;
            sum[r2+1][c1] -= degree;
            sum[r2+1][c2+1] += degree;
        }
        
        for(int i=0; i<n; i++){
            for(int j=1; j<=m; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        
        for(int j=0; j<m; j++){
            for(int i=1; i<=n; i++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        int cnt = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]+sum[i][j] >= 1){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}