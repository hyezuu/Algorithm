import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Integer>[] graph;
  static int[][] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    graph = new List[N + 1];
    tree = new int[N + 1][2];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    setTree(0, 1);

    int M = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(lca(a, b)).append("\n");
    }

    System.out.println(sb);
  }

  static void setTree(int pNode, int node) {
    tree[node][0] = pNode;
    tree[node][1] = tree[pNode][1] + 1; //depth

    for (int child : graph[node]) {
      if (child == pNode) {
        continue;
      }
      setTree(node, child);
    }
  }

  static int lca(int a, int b) {
    //sync depth, 큰 값을 a로
    if (tree[b][1] > tree[a][1]) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    while (tree[a][1] > tree[b][1]) {
      a = tree[a][0];
    }

    while (a!=b) {
      a = tree[a][0];
      b = tree[b][0];
    }
    return a;
  }
}