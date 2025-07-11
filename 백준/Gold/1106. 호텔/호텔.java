import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int C, N;
  static int[] cost, value;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //목표값
    C = Integer.parseInt(st.nextToken());
    //도시수
    N = Integer.parseInt(st.nextToken());

    cost = new int[N];
    value = new int[N];

    //도시에 얼마까지 투자할 수 있나
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cost[i] = Integer.parseInt(st.nextToken());
      value[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(solve());
  }

  static int solve(){
    final int INF = Integer.MAX_VALUE;

    //i명을 확보하기위한 최소 비용
    int[] dp = new int[C+1];
    Arrays.fill(dp, INF);
    dp[0] = 0;

    for(int i=0; i<N; i++){
      int v = value[i];
      int cst = cost[i];

      //j명 확보한 상태에서 추가로 돈 쓸때
      for(int j=0; j<=C; j++){
        if (dp[j] == INF) continue;

        //현재 확보한 j명에 v명을 더해서, 새롭게 확보할 고객 수를 계산
        int nj = Math.min(C, j+v);

        //확보할 고객수의 최소 비용;
        dp[nj] = Math.min(dp[nj], dp[j]+cst);
      }
    }

    return dp[C];
  }
}