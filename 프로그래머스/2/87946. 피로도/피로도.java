class Solution {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, 0);
        return max;
    }
    
    static void dfs(int k, int[][]dungeons, int cnt){
        max = Math.max(cnt, max);
        for(int[] d : dungeons){
            int a = d[0], b = d[1];
            if(k>=d[0]){
                d[0] = 9999;
                dfs(k-b, dungeons, cnt+1);
                d[0] = a;
            }
        }
    }
}