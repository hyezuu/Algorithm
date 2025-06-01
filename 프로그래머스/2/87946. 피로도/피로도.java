class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        return dfs(visited, k, dungeons, 0);
    }
    
    public int dfs(boolean[] visited, int k, int[][] dungeons, int cnt){
        int maxCount = cnt;
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            int required = dungeons[i][0];
            int consumed = dungeons[i][1];
            
            if(k >= required){
                visited[i] = true;
                maxCount = Math.max(
                    dfs(visited, k-consumed, dungeons, cnt+1),maxCount);
                visited[i] = false;
            }
        }
        return maxCount;
    }
}