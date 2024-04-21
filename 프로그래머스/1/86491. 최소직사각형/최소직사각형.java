class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0; 
        for(int i =0; i<sizes.length; i++){
            int tmpX = Math.max(sizes[i][1], sizes[i][0]);
            int tmpY = Math.min(sizes[i][1], sizes[i][0]);
            
            x = Math.max(tmpX, x);
            y = Math.max(tmpY, y);
        }
        
        return x*y;
    }
}