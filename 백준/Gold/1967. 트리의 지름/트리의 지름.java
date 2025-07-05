import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static List<Node>[] graph;
  static int farthest;
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
    dfs(1, 0, 0);
    dfs(farthest, 0, 0);
    return max;
  }

  static void dfs(int vertex, int distance, int parent){
    for(Node child: graph[vertex]){
      if(child.vertex == parent) continue;
      int nextDistance = child.distance + distance;
      if(nextDistance > max){
        farthest = child.vertex;
        max = nextDistance;
      }
      dfs(child.vertex, nextDistance, vertex);
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
