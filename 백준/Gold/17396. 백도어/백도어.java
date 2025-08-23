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
  static boolean[] wards;
  static List<Node>[] distances;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    wards = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      if (Integer.parseInt(st.nextToken()) == 1) {
        wards[i] = true;
      }
    }

    distances = new List[N];

    for (int i = 0; i < N; i++) {
      distances[i] = new ArrayList<>();
    }

    for (int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      distances[a].add(new Node(b, t));
      distances[b].add(new Node(a, t));
    }
    br.close();
    System.out.print(solve());
  }

  static long solve() {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.cost));
    pq.offer(new Node(0, 0));
    long[] dists = new long[N];
    Arrays.fill(dists, Long.MAX_VALUE);
    dists[0] = 0;

    while(!pq.isEmpty()) {
      Node node = pq.poll();
      if (node.cost != dists[node.to]) continue;
      if (node.to == N-1) return node.cost;

      for(Node n : distances[node.to]) {
        if (wards[n.to] && n.to != N-1) continue;
        if (dists[n.to] <= node.cost + n.cost) continue;
        dists[n.to] = node.cost + n.cost;
        pq.offer(new Node(n.to, node.cost + n.cost));
      }
    }
    return -1;
  }

  static class Node {
    int to;
    long cost;

    public Node(int to, long cost) {
      this.to = to;
      this.cost = cost;
    }
  }
}
