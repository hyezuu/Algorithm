import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static List<Integer>[] graph;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      graph = new List[N];

      for(int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
      }

      for(int i=0; i< K; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        graph[a].add(b);
        graph[b].add(a);
      }
      sb.append(isBipartite() ? "YES\n" : "NO\n");
    }
    System.out.print(sb);
  }
  static boolean isBipartite() {
    int[] color = new int[N]; // 0=미방문, 1=빨강, -1=파랑

    for (int start = 0; start < N; start++) {
      if (color[start] != 0) continue; // 이미 칠했으면 패스

      Queue<Integer> q = new ArrayDeque<>();
      q.offer(start);
      color[start] = 1; // 시작 색

      while (!q.isEmpty()) {
        int cur = q.poll();

        for (int next : graph[cur]) {
          if (color[next] == 0) {
            color[next] = -color[cur];
            q.offer(next);
          } else if (color[next] == color[cur]) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
