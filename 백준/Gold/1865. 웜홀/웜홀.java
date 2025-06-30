import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
      if(spfa(i)){
        hasMinusCycle = true;
        break;
      }
    }
    sb.append(hasMinusCycle ? YES: NO);
  }
  public static boolean spfa(int start) {
    int[] dist = new int[N + 1];
    boolean[] inQueue = new boolean[N + 1];
    int[] count = new int[N + 1];  // 각 정점이 큐에 들어간 횟수

    Arrays.fill(dist, INF);
    Queue<Integer> queue = new LinkedList<>();

    dist[start] = 0;
    queue.offer(start);
    inQueue[start] = true;
    count[start] = 1;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      inQueue[current] = false;

      for (int[] edge : graph[current]) {
        int next = edge[0];  // 도착점
        int weight = edge[1];  // 가중치

        if (dist[next] > dist[current] + weight) {
          dist[next] = dist[current] + weight;

          if (!inQueue[next]) {
            queue.offer(next);
            inQueue[next] = true;
            count[next]++;

            // 음의 사이클 체크: 한 정점이 N번 이상 큐에 들어가면 음의 사이클
            if (count[next] >= N) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}