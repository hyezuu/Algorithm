import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static List<List<int[]>> graph;
  static int V, E, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    K = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();

    for (int i = 0; i <= V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      graph.get(from).add(new int[]{to, value});
    }
    
    int[] result = dijkstra();
    for(int i=1; i<result.length; i++){
      int dist = result[i];
      System.out.println(dist == Integer.MAX_VALUE ? "INF" : dist);
    }
  }

  static int[] dijkstra () {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    int[] dist = new int[V+1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[K] = 0;
    pq.offer(new int[]{K, 0});

    while (!pq.isEmpty()) {
      //확정할 수 있는 노드가 나온다.
      int[] node = pq.poll();
      int current = node[0];
      int cost = node[1];

      if(cost > dist[current]) continue;

      for (int[] next : graph.get(current)) {
        int nextNode = next[0];
        int nextCost = next[1];

        if(cost + nextCost < dist[nextNode]){
          dist[nextNode] = cost + nextCost;
          pq.offer(new int[]{nextNode, cost + nextCost});
        }
      }
    }
    return dist;
  }
}
