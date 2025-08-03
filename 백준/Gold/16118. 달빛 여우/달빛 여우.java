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
  static long[][] dists; // [0]=늑대홀수, [1]=늑대짝수, [2]=여우

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
    dists = new long[3][N];
    
    for(int i = 0; i < N; i++) {
      dists[0][i] = Long.MAX_VALUE;
      dists[1][i] = Long.MAX_VALUE;
      dists[2][i] = Long.MAX_VALUE;
    }
    
    dijkstraForFox();
    dijkstraForWolf();

    int count = 0;
    for(int i = 1; i < N; i++) {
      long foxTime = dists[2][i];
      long wolfTime = Math.min(dists[0][i], dists[1][i]);
      if(foxTime < wolfTime) {
        count++;
      }
    }
    return count;
  }

  static void dijkstraForFox() {
    dists[2][0] = 0;
    
    PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
    pq.offer(new long[]{0, 0}); // {노드, 비용}

    while(!pq.isEmpty()) {
      long[] current = pq.poll();
      int node = (int)current[0];
      long cost = current[1];

      if(cost > dists[2][node]) continue;

      for(Road road : roads[node]) {
        long nextCost = cost + road.cost * 2;

        if(dists[2][road.to] > nextCost) {
          dists[2][road.to] = nextCost;
          pq.offer(new long[]{road.to, nextCost});
        }
      }
    }
  }

  static void dijkstraForWolf() {
    dists[0][0] = 0; // 늑대는 홀수번째부터 시작

    PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
    pq.offer(new long[]{0, 0, 0}); // {노드, 비용, 상태: 0=홀수, 1=짝수}

    while(!pq.isEmpty()) {
      long[] current = pq.poll();
      int node = (int)current[0];
      long cost = current[1];
      int state = (int)current[2]; // 0=홀수번째, 1=짝수번째

      if(cost > dists[state][node]) continue;

      int nextState = 1 - state; // 홀수-짝수 토글
      
      for(Road road : roads[node]) {
        long nextCost = cost + (long)road.cost * (state == 0 ? 1 : 4);

        if(dists[nextState][road.to] > nextCost) {
          dists[nextState][road.to] = nextCost;
          pq.offer(new long[]{road.to, nextCost, nextState});
        }
      }
    }
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