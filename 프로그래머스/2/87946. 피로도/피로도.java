class Solution {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        return max;
    }
    
    static void dfs(int k, int[][]dungeons, int cnt, boolean[] visited){
        max = Math.max(cnt, max);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, cnt+1, visited);
                visited[i] = false;
            }
        }
    }
}