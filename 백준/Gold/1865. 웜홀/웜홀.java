import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, M, W;
  static List<int[]>[] graph;
  static StringBuilder sb = new StringBuilder();
  static final String YES = "YES\n";
  static final String NO = "NO\n";
  static final int INF = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int TC = Integer.parseInt(br.readLine());
    for (int i = 0; i < TC; i++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());

      graph = new List[N+1];

      for (int j = 0; j < N+1; j++) {
        graph[j] = new ArrayList<>();
      }

      //도로, 무방향
      for (int j = 0; j < M + W; j++) {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        if (j < M){
          graph[E].add(new int[]{S, T});
          graph[S].add(new int[]{E, T});
        }
        else graph[S].add(new int[]{E, -T});
      }

      solve();
    }
    System.out.println(sb);
  }
  static void solve() {
    boolean hasMinusCycle = false;
    for(int i=1; i<=N; i++) {
      if(bellmanFord(i)){
        hasMinusCycle = true;
        break;
      }
    }
    sb.append(hasMinusCycle ? YES: NO);
  }
  static boolean bellmanFord(int start) {
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    boolean isUpdated = false;
    for(int i=1; i<=N; i++) {
      isUpdated = false;
      for(int j=1; j<=N; j++) {
        for(int[] edge: graph[j]) {
          int e = edge[0];
          int t = edge[1];

          if(dist[j] == INF) continue;
          if(dist[e] > dist[j] + t) {
            dist[e] = dist[j] + t;
            isUpdated = true;
            if(i==N) return true;
          }
        }
      }
      if(!isUpdated) break;
    }
    return false;
  }
}