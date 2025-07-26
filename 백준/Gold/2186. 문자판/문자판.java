import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static char[][] chars;
  static String target;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int[][][] dp;

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

    dp = new int[N][M][target.length()];

    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        Arrays.fill(dp[i][j], -1);
      }
    }

    solve();
  }

  static void solve(){
    int cnt = 0;
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        cnt+=dfs(i, j, 0);
      }
    }
    System.out.print(cnt);
  }

  static int dfs(int y, int x, int idx){
    if(target.charAt(idx) != chars[y][x]) return 0;
    if(idx == target.length()-1) return 1;
    if(dp[y][x][idx] != -1) return dp[y][x][idx];

    dp[y][x][idx] = 0;

    for(int i=0; i<4; i++){
      for(int j=1; j<=K; j++){
        int ny = y + dy[i] * j;
        int nx = x + dx[i] * j;
        if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        dp[y][x][idx] += dfs(ny, nx, idx+1);
      }
    }
    return dp[y][x][idx];
  }
}
