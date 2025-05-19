import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int[] branch = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      branch[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(dp(N, K, branch));
  }

  static long dp(int N, int K, int[] branch) {
    int[][] dp = new int[2][N + 1];
    int[] max = new int[N + 1];

    dp[1][0] = 1;
    for (int i = 1; i <= N; i++) {
      if (dp[0][i - 1] >= K) {
        int past = dp[0][i - 1];
        int slide = dp[0][i - 1] - branch[dp[1][i - 1]] + branch[i];
        //슬라이드
        if((past == K || past < slide) && dp[0][i - 1] - branch[dp[1][i - 1]] < K) {
          dp[0][i] = slide;
          dp[1][i] = dp[1][i - 1] + 1;
          if(past != K) {
            max[i] = max[i-1] - branch[dp[1][i - 1]] + branch[i];
            continue;
          }
        }
        //새로시작
        else {
          dp[0][i] = branch[i];
          dp[1][i] = i;
        }
      }
      //그냥 더함
      else {
        dp[0][i] = dp[0][i - 1] + branch[i];
        dp[1][i] = dp[1][i - 1];
      }
      max[i] = max[i-1] + Math.max(dp[0][i]-K, 0);
    }

    return max[N];
  }
}