import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] routes;
  static final int INF = Integer.MAX_VALUE>>1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    routes = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(routes[i], INF);
      routes[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int from = Integer.parseInt(st.nextToken())-1;
      int to = Integer.parseInt(st.nextToken())-1;
      int cost = Integer.parseInt(st.nextToken());

      routes[from][to] = Math.min(routes[from][to], cost);
    }

    br.close();
    System.out.print(solve());
  }

  static String solve() {

    for(int k = 0; k < N; k++) {
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        sb.append(routes[i][j] >= INF ? 0 : routes[i][j]).append(" ");
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}
