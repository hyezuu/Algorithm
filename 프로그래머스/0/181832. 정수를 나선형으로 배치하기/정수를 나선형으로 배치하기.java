class Solution {
    public int[][] solution(int n) {
        int[] posy = {1, 0, -1, 0};
        int[] posx = {0, 1, 0, -1};
        
        int[][] answer = new int[n][n];
        
        int nx = 0, ny = 0;
         
        for(int i=1, j=0; i<=n*n; i++){
            answer[nx][ny] = i;
            
            if(nx+posx[j%4] < 0 || nx+posx[j%4] >= n || ny+posy[j%4] < 0 || ny+posy[j%4] >= n || answer[nx+posx[j%4]][ny+posy[j%4]]!=0){
                j++;
            }
            nx += posx[j%4];
            ny += posy[j%4];            
            }
        return answer;
        
    }
}