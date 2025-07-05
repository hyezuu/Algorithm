import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static List<Node>[] graph;
  static boolean[] visited;
  static int farthestNode;
  static int max = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new List[N+1];

    for(int i = 0; i < N+1; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i=1; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a].add(new Node(b, c));
      graph[b].add(new Node(a, c));
    }

    System.out.print(solve());
  }

  static int solve() {
    visited = new boolean[N+1];
    dfs(1, 0);

    visited = new boolean[N+1];
    dfs(farthestNode, 0);
    return max;
  }

  static void dfs(int vertex, int distance){
    visited[vertex] = true;

    for(Node child: graph[vertex]){
      if(visited[child.vertex]) continue;
      int nextDistance = child.distance + distance;
      if(nextDistance > max){
        farthestNode = child.vertex;
        max = nextDistance;
      }
      dfs(child.vertex, nextDistance);
    }
  }

  static class Node{
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }
  }
}
