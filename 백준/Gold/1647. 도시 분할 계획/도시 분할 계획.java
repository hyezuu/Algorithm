import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    parent = new int[N];

    for(int i = 0; i < N; i++) {
      parent[i] = i;
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) -1;
      int cost = Integer.parseInt(st.nextToken());

      pq.offer(new Road(from, to, cost));
    }

    System.out.print(solve());
  }

  static int solve() {
    int maxCost = 0;
    int answer = 0;
    while(!pq.isEmpty()) {
      Road road = pq.poll();
      if(union(road.from, road.to)) {
        answer += road.cost;
        maxCost = road.cost;
      }
    }

    return answer - maxCost;
  }

  static int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  static boolean union(int x, int y){
    x = find(x);
    y = find(y);

    if(x == y) return false;
    parent[x] = y;
    return true;
  }

  static class Road {
    int from;
    int to;
    int cost;

    public Road(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }
}