import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static List<int[]>[] tree;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    tree = new List[N+1];

    for(int i = 0; i <= N; i++){
      tree[i] = new ArrayList<>();
    }

    for(int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      tree[a].add(new int[]{b, d});
      tree[b].add(new int[]{a, d});
    }

    sb = new StringBuilder();

    for(int i = 0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      solve(from, to);
    }
    System.out.println(sb.toString());
  }

  static void solve(int from, int to) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{from, 0});
    boolean[] visited = new boolean[N+1];
    visited[from] = true;

    while(!stack.isEmpty()){
      int[] current = stack.pop();
      int node = current[0];
      int cost = current[1];
      if(node == to) {
        sb.append(cost).append("\n");
        return;
      }

      for(int[] next : tree[node]){
        int nextNode = next[0];
        int nextCost = next[1];

        if(!visited[nextNode]){
          visited[nextNode] = true;
          stack.push(new int[]{nextNode, cost + nextCost});
        }
      }
    }
  }
}