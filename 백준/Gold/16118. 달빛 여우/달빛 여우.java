import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static List<Road>[] roads;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    roads = new ArrayList[N];

    for(int i=0; i<N; i++){
      roads[i] = new ArrayList<>();
    }

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken())-1;
      int to = Integer.parseInt(st.nextToken())-1;
      int cost = Integer.parseInt(st.nextToken());

      roads[from].add(new Road(to, cost));
      roads[to].add(new Road(from, cost));
    }

    System.out.print(solve());
  }

  static int solve() {
    int[] foxDist = dijkstraFox();
    int[] wolfDist = dijkstraWolf();

    int count = 0;
    for(int i = 1; i < N; i++) {
      if(foxDist[i] < wolfDist[i]) {
        count++;
      }
    }
    return count;
  }

  static int[] dijkstraFox() {
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{0, 0}); // {노드, 비용}

    while(!pq.isEmpty()) {
      int[] current = pq.poll();
      int node = current[0];
      int cost = current[1];

      if(cost > dist[node]) continue;

      for(Road road : roads[node]) {
        int nextCost = cost + road.cost * 2;

        if(dist[road.to] > nextCost) {
          dist[road.to] = nextCost;
          pq.offer(new int[]{road.to, nextCost});
        }
      }
    }
    return dist;
  }

  static int[] dijkstraWolf() {
    int[][] dist = new int[N][2]; // [홀수번째][짝수번째]
    for(int i = 0; i < N; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    dist[0][1] = 0; // 늑대는 홀수번째부터 시작

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{0, 0, 1}); // {노드, 비용, 상태: 1=홀수, 0=짝수}

    while(!pq.isEmpty()) {
      int[] current = pq.poll();
      int node = current[0];
      int cost = current[1];
      int state = current[2]; // 1=홀수번째, 0=짝수번째

      if(cost > dist[node][state]) continue;

      for(Road road : roads[node]) {
        int nextCost = cost + (state == 1 ? road.cost : road.cost * 4);
        int nextState = 1 - state;

        if(dist[road.to][nextState] > nextCost) {
          dist[road.to][nextState] = nextCost;
          pq.offer(new int[]{road.to, nextCost, nextState});
        }
      }
    }

    int[] result = new int[N];
    for(int i = 0; i < N; i++) {
      result[i] = Math.min(dist[i][0], dist[i][1]);
    }
    return result;
  }

  static class Road {
    int to;
    int cost;

    public Road(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }
}