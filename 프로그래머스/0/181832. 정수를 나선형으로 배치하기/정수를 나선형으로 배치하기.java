class Solution {
    public int[][] solution(int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int[][] answer = new int[n][n];
        int nx = 0;
        int ny = 0;
        int idx = 0;
        int posIdx = 0;
        for(int i=1; i<=n*n; i++){
            answer[nx][ny] = i;
            int tmpX = nx + dx[idx%4];
            int tmpY = ny + dy[idx%4];
            
            if(tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= n || answer[tmpX][tmpY] != 0){
                idx++;
                nx+= dx[idx%4];
                ny+= dy[idx%4];
            }
            
            else {
                nx = tmpX;
                ny = tmpY;
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