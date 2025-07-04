import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static int[] weight;
  static int[] value;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    weight = new int[N+1];
    value = new int[N+1];

    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      weight[i] = w;
      value[i] = v;
    }

    System.out.println(solve());
  }

  static int solve(){
    int[] dp = new int[K+1];  

    for(int i = 1; i <= N; i++) {
      for(int j = K; j >= weight[i]; j--) {  
        dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
      }
    }

    return dp[K];
  }
}