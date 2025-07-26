import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

   static int N, M, K;
   static char[][] chars;
   static String target;
   static int[] dx = {-1, 0, 1, 0};
   static int[] dy = {0, -1, 0, 1};
   static Integer[][][] dp; // int -> Integer로 변경 (null 체크 가능)

   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       K = Integer.parseInt(st.nextToken());
       chars = new char[N][M];

       for (int i = 0; i < N; i++) {
           chars[i] = br.readLine().toCharArray();
       }

       target = br.readLine();
       solve();
   }

   static void solve() {
       dp = new Integer[N][M][target.length()];
       
       char firstChar = target.charAt(0);
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               if (chars[i][j] == firstChar) {
                   dp[i][j][0] = 1;
               } else {
                   dp[i][j][0] = 0;
               }
           }
       }

       int cnt = 0;
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               cnt += dfs(i, j, target.length() - 1);
           }
       }
       System.out.print(cnt);
   }

   static int dfs(int y, int x, int idx) {
       if (dp[y][x][idx] != null) {
           return dp[y][x][idx];
       }

       dp[y][x][idx] = 0;

       if (target.charAt(idx) == chars[y][x]) {
           
               for (int i = 0; i < 4; i++) {
                   for (int j = 1; j <= K; j++) {
                       int ny = y + dy[i] * j;
                       int nx = x + dx[i] * j;
 
                       if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                           dp[y][x][idx] += dfs(ny, nx, idx - 1);
                       }
                   }
               
           }
       }

       return dp[y][x][idx];
   }
}