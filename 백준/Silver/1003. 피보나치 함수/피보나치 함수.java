import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    init();

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());

      sb.append(dp[N][0])
          .append(" ")
          .append(dp[N][1])
          .append('\n');
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static void init() {
    dp = new int[41][2];

    dp[0][0] = 1;
    dp[1][1] = 1;

    for (int i = 2; i <41; i++){
      dp[i][0] = dp[i-1][0] + dp[i-2][0];
      dp[i][1] = dp[i-1][1] + dp[i-2][1];
    }
  }
}
