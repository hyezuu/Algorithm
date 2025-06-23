import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int F, S, G, U, D;
  final static String CAN_NOT_MOVE = "use the stairs";

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    F = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    int result = solve();

    System.out.println(result == -1 ? CAN_NOT_MOVE : result);
  }

  static int solve() {
    Queue<int[]> q = new LinkedList<>();
    boolean[] visited = new boolean[F+1];
    q.offer(new int[]{S, 0});
    visited[S] = true;
    int[] dz = {+U, -D};

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int floor = cur[0];
      int count = cur[1];

      if (floor == G) {
        return count;
      }

      for(int i=0; i<2; i++){
        int nz = floor + dz[i];
        if(nz > F || nz < 1) continue;
        if(visited[nz]) continue;
        visited[nz] = true;
        q.offer(new int[]{nz, count+1});
      }
    }
    return -1;
  }
}
