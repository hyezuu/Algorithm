import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, K;
  static final int MOD = 1_000_000_003;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());

    System.out.print(solve());
  }

  static int solve() {
    if(K*2 > N) return 0;
    if(K*2 == N) return 2;
    int[][] dp = new int[N+1][K+1];

    for(int i=0; i<=N; i++) {
      dp[i][1] = i;//N개중에 1개를 선택하는 경우의수는 i개
      dp[i][0] = 1;
    }

    //선형
    for(int i=2; i<N; i++) {
      for(int j=2; j<=K; j++) {
        //i개의 칸 중에서 j개를 인접하지 않게 고르는 경우의 수
        //i번째 칸을 선택한 경우 -> i-1은 선택못함. i-2까지에서 j-1개를 고름

        dp[i][j] = dp[i-2][j-1] + dp[i-1][j];
        dp[i][j] %= MOD;
      }
    }
    //원형 (N번째 칸을 선택한경우는 1, N, N-2 제외
    return (dp[N-1][K] + dp[N-3][K-1])%MOD;
  }
}