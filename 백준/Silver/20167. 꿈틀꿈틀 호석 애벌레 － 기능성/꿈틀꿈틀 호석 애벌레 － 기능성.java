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

    for(int i = 1; i <= N; i++) {
      branch[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(dp(N, K, branch));
  }

  static long dp(int N, int K, int[] branch) {
    int[] dp = new int[N + 1];
    int[] max = new int[N + 1];
    //dp[0] = 축적에너지 최대
    //dp[1] = 탈피에너지 최대

    for(int i=1; i<=N; i++){
      if(dp[i-1] >= K){
        if(dp[i-1] == K) dp[i] = branch[i];
        else if(dp[i-1] > branch[i]+branch[i-1]){
          dp[i] = branch[i];
        }
        else dp[i] = branch[i]+dp[i-1];
      }
      else dp[i] = dp[i-1]+branch[i];
//      dp[i] = dp[i-1] > K ? Math.max(dp[i-1], branch[i]+branch[i-1]) : branch[i-1]+branch[i];
      max[i] = max[i-1] + (dp[i] >= K ? dp[i]-K : max[i]);
    }

    return max[N];
  }
}