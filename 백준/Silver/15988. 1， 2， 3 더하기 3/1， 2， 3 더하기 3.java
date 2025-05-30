import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static long[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    dp = new long[1000001];

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp(n)).append('\n');
    }

    System.out.println(sb);
  }

  static long dp(int n){
    if(dp[n] > 0) return dp[n];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for(int i=4; i<=n; i++){
      dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1_000_000_009L;
    }

    return dp[n];
  }
}