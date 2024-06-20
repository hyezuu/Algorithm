class Solution {
    public int[][] solution(int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int[][] answer = new int[n][n];
        int x = 0;
        int y = 0;
        int idx = 0;
        for(int i=1; i<=n*n; i++){
            answer[x][y] = i;
            int nx = x + dx[idx%4];
            int ny = y + dy[idx%4];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0){
                idx++;
                x += dx[idx%4];
                y += dy[idx%4];
            }
            
            else {
                x = nx;
                y = ny;
            }
            
        }
        return answer;
        
        
        
        
        
        
//         int[] posy = {1, 0, -1, 0};
//         int[] posx = {0, 1, 0, -1};
        
//         int[][] answer = new int[n][n];
        
//         int nx = 0, ny = 0;
         
//         for(int i=1, j=0; i<=n*n; i++){
//             answer[nx][ny] = i;
            
//             if(nx+posx[j%4] < 0 || nx+posx[j%4] >= n || ny+posy[j%4] < 0 || ny+posy[j%4] >= n || answer[nx+posx[j%4]][ny+posy[j%4]]!=0){
//                 j++;
//             }
//             nx += posx[j%4];
//             ny += posy[j%4];            
//             }
//         return answer;
        
    }
}