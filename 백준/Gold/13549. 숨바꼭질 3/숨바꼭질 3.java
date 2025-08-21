import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int N, K;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    //수빈이
    N = Integer.parseInt(st.nextToken());
    //동생
    K = Integer.parseInt(st.nextToken());
    System.out.print(solve());
  }

  static int solve() {
    if (N >= K) return N - K;
    int MAX = K * 2;
    int[] dist = new int[MAX+1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
    pq.offer(new Node(N, 0));
    dist[N] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      if(node.time != dist[node.cur]) continue;
      if (node.cur == K) return node.time;

      int nx = node.cur * 2;
      if (nx <= MAX && dist[nx] > node.time) {
        dist[nx] = node.time;
        pq.offer(new Node(nx, node.time));
      }

      nx = node.cur - 1;
      if (nx >= 0 && dist[nx] > node.time + 1) {
        dist[nx] = node.time + 1;
        pq.offer(new Node(nx, node.time + 1));
      }

      nx = node.cur + 1;
      if (nx <= MAX && dist[nx] > node.time + 1) {
        dist[nx] = node.time + 1;
        pq.offer(new Node(nx, node.time + 1));
      }
    }

    return dist[K];
  }

  static class Node {
    int cur;
    int time;

    public Node(int cur, int time) {
      this.cur = cur;
      this.time = time;
    }
  }
}
