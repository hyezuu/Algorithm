import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int V, E, K;
  static List<int[]>[] graph;
  static final String INF = "INF";
  static final String NEW_LINE = "\n";

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    K = Integer.parseInt(br.readLine())-1;

    graph = new List[V];

    for(int i=0; i<V; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken())-1;
      int to = Integer.parseInt(st.nextToken())-1;
      int cost = Integer.parseInt(st.nextToken());

      graph[from].add(new int[]{to, cost});
    }

    StringBuilder sb = new StringBuilder();

    for(int d : dijkstra()){
      sb.append(d == Integer.MAX_VALUE ? INF : d).append(NEW_LINE);
    }

    System.out.println(sb);
  }

  static int[] dijkstra(){
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    int[] dist = new int[V];
//    boolean[] visited = new boolean[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[K] = 0;
    pq.offer(new int[]{K, 0});

    while(!pq.isEmpty()){
      int[] current = pq.poll();
      int vertex = current[0];
      int cost = current[1];

      for(int[] next : graph[vertex]){
        int nextVertex = next[0];
        int nextCost = cost + next[1];

        if(nextCost < dist[nextVertex]){
          dist[nextVertex] = nextCost;
          pq.offer(new int[]{nextVertex, nextCost});
        }
      }
    }
    return dist;
  }
}