import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[][] route;
  static int minMaxCost = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    route = new int[n+1][n+1];

    for(int i=1; i<=m; i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      route[start][end] = cost;
      route[end][start] = cost;
    }

    boolean[] visited = new boolean[n+1];
    visited[a] = true;
    dfs(a, b, c, 0, visited);

    if (minMaxCost == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(minMaxCost);
    }
  }
  
  public static void dfs(int start, int end, int cost, int maxCost, boolean[] visited) {
    if (start == end) {
      minMaxCost = Math.min(minMaxCost, maxCost);
      return;
    }
    
    for (int next = 1; next <= n; next++) {
      if (route[start][next] == 0 || visited[next] || route[start][next] > cost) {
        continue;
      }

      visited[next] = true;

      int newMaxCost = Math.max(maxCost, route[start][next]);
      dfs(next, end, cost - route[start][next], newMaxCost, visited);

      visited[next] = false;
    }
  }
}