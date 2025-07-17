import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int n, d, c;
  static List<int[]>[] dependencies;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
      d = Integer.parseInt(st.nextToken()); // 의존성 갯수
      c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호

      dependencies = new List[n+1];

      for (int i = 0; i < n+1; i++) {
        dependencies[i] = new ArrayList<>();
      }

      for(int i=0; i<d; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        dependencies[b].add(new int[]{a,t});
      }
      solve();
    }
    System.out.print(sb);
  }

  static void solve() {
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[c] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{c, 0});

    while(!pq.isEmpty()){
      int[] p = pq.poll();
      int cur = p[0], time = p[1];
      if(time > dist[cur]) continue;

      for(int[] dep : dependencies[cur]){
        int v = dep[0], w = dep[1];
        if(dist[v] > time + w) {
          dist[v] = time + w;
          pq.offer(new int[]{v, dist[v]});
        }
      }
    }

    int cnt = 0, maxTime = 0;
    for (int i = 1; i <= n; i++) {
      if (dist[i] != Integer.MAX_VALUE) {
        cnt++;
        maxTime = Math.max(maxTime, dist[i]);
      }
    }

    sb.append(cnt).append(" ").append(maxTime).append("\n");
  }
}