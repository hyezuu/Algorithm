import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());

      sb.append(solve(k, n)).append("\n");
    }

    System.out.print(sb);
  }

  static int solve(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];

    for (int i = 1; i <= k; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[n][k];
  }
}

