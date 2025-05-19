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
    int[][] dp = new int[2][N + 1]; // dp[0][i]는 현재 합, dp[1][i]는 시작점
    int[] max = new int[N + 1];     // 최대 탈피 에너지

    for (int i = 1; i <= N; i++) {
      // 기본적으로 이전 상태 가져오기
      max[i] = max[i-1];

      // 현재 먹이를 시작점으로 하는 새로운 연속 구간 시작
      int currentSum = branch[i];
      int startIdx = i;

      // 이전에 구간이 진행 중이었다면 해당 구간에 현재 먹이 추가
      if (dp[0][i-1] > 0) {
        int prevSum = dp[0][i-1];
        int prevStart = dp[1][i-1];

        // 이전 구간에 현재 먹이 추가
        int newSum = prevSum + branch[i];

        // 합이 K 이상이면 탈피 에너지 획득하고 구간 종료
        if (newSum >= K) {
          max[i] = Math.max(max[i], max[i-1] + newSum - K);
          dp[0][i] = 0; // 구간 종료
          dp[1][i] = 0;
          continue;
        } else {
          // 이전 구간 이어서 진행
          currentSum = newSum;
          startIdx = prevStart;
        }
      }

      // 현재 먹이만으로 K 이상이면 탈피 에너지 획득하고 구간 종료
      if (currentSum >= K) {
        max[i] = Math.max(max[i], max[i-1] + currentSum - K);
        dp[0][i] = 0;
        dp[1][i] = 0;
      } else {
        // 구간 정보 저장하고 계속 진행
        dp[0][i] = currentSum;
        dp[1][i] = startIdx;

        // 현재 먹이를 건너뛰는 선택도 고려
        if (max[i-1] > max[i]) {
          max[i] = max[i-1];
          dp[0][i] = 0;
          dp[1][i] = 0;
        }
      }
    }

    return max[N];
  }
}