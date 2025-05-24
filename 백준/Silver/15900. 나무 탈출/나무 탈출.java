import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static List<Integer>[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    tree = new List[n + 1];

    for(int i = 1; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      tree[x].add(y);
      tree[y].add(x);
    }

    System.out.println(bfs(n)%2==1 ? "Yes" : "No");
  }

  public static int bfs(int n) {
    Queue<int[]> q = new LinkedList<>();
    boolean[] visited = new boolean[n+1];
    int sum = 0;

    q.offer(new int[]{1, 0});
    visited[1] = true;

    while (!q.isEmpty()) {
      int[] node = q.poll();
      int parent = node[0];
      int depth = node[1];
      boolean isLeaf = true;
      for(Integer child : tree[parent]) {
        if(!visited[child]) {
          isLeaf = false;
          visited[child] = true;
          q.offer(new int[]{child, depth+1});
        }
      }
      if(isLeaf) {
        sum += depth;
      }
    }
    return sum;
  }
}
