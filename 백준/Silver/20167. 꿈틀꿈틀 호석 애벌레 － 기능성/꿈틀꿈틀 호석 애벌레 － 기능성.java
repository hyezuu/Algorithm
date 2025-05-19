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

    int[] energy = new int[N];

    for (int i = 0; i <N; i++) {
      energy[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(N, K, energy));
  }

  static int solve(int N, int K, int[] energy) {
    int[] value = new int[N+1];
    int[] size = new int[N+1];

    int left = 0;
    int right = 0;
    int sum = energy[0];

    while(left <= right) {
      if(sum >= K || right == N-1) {
        size[left] = right - left + 1;
        value[left] = Math.max(0, sum - K);
        if(size[left] == 1 && right != N-1) sum += energy[++right];
        sum -= energy[left++];
      } else {
        sum += energy[++right];
      }
    }

    int[] dp = new int[N+1];

    for(int i = N-1; i >= 0; i--) {
      dp[i] = Math.max(dp[i+1], dp[i+size[i]] + value[i]);
    }
    return dp[0];
  }
}