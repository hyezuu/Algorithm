import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int n, m, r;
  static int[] items;
  static List<Edge>[] graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken()); // 지역의 개수
    m = Integer.parseInt(st.nextToken()); // 수색 범위
    r = Integer.parseInt(st.nextToken()); // 길의 개수

    st = new StringTokenizer(br.readLine());
    items = new int[n+1];

    for(int i=1; i<=n; i++){
      items[i] = Integer.parseInt(st.nextToken());
    }

    graph = new List[n+1];

    for(int i=0; i<=n; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i=0; i<r; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph[from].add(new Edge(to, cost));
      graph[to].add(new Edge(from, cost));
    }

    System.out.print(dijkstra());
  }

  static int dijkstra(){
    int[][] dist = new int[n+1][n+1];
    int max = Integer.MIN_VALUE;
    for(int i=1; i<=n; i++){
      Arrays.fill(dist[i], Integer.MAX_VALUE);
      dist[i][i] = 0;
      int sum = 0;

      PriorityQueue<Edge> pq = new PriorityQueue<>();
      pq.offer(new Edge(i, 0));

      while(!pq.isEmpty()){
        Edge current = pq.poll();
        int currentCost = current.cost;
        int currentNode = current.to;

        if(dist[i][currentNode] < currentCost) continue;
        sum += items[currentNode];

        for(Edge next: graph[currentNode]){
          int nextNode = next.to;
          int nextCost = next.cost + currentCost;

          if(dist[i][nextNode] > nextCost && nextCost <= m){
            dist[i][nextNode] = nextCost;
            pq.offer(new Edge(nextNode, dist[i][nextNode]));
          }
        }
      }
      max = Math.max(max, sum);
    }
    return max;
  }

  static class Edge implements Comparable<Edge>{
    int to;
    int cost;

    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }
  }
}
