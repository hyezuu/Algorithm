import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static List<Edge>[] graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    graph = new List[N];

    for(int i = 0; i < N; i++){
      graph[i] = new ArrayList<>();
    }

    StringTokenizer st;

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      int cost = Integer.parseInt(st.nextToken());

      graph[from].add(new Edge(to, cost));
    }

    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken()) - 1;
    int end = Integer.parseInt(st.nextToken()) - 1;

    System.out.println(dijkstra(start, end));
  }

  static int dijkstra(int start, int end){
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[N];
    pq.offer(new Edge(start, 0));

    while (!pq.isEmpty()){
      Edge current = pq.poll();
      if(visited[current.to]) continue;
      visited[current.to] = true;
      if(current.to == end) return current.cost;

      for(Edge next : graph[current.to]){
        pq.offer(new Edge(next.to, current.cost + next.cost));
      }
    }
    return -1;
  }

  static class Edge implements Comparable<Edge>{
    int to;
    int cost;

    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(cost, o.cost);
    }
  }
}
