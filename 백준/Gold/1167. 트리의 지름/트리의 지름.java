import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int V;
  static List<Node>[] graph;
  static int farthestNode;
  static int maxDistance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    V = Integer.parseInt(br.readLine());
    graph = new List[V + 1];
    
    for (int i = 0; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    StringTokenizer st;

    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(br.readLine());
      //정점번호
      int n = Integer.parseInt(st.nextToken());
      //다른정점번호
      int m = Integer.parseInt(st.nextToken());
      while (m != -1) {
        //거리
        int d = Integer.parseInt(st.nextToken());
        graph[n].add(new Node(m, d));

        m = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve());
  }

  static int solve() {
    farthestNode = 0;
    maxDistance = 0;

    dfs(1,0,0);

    dfs(farthestNode, 0, 0);
    return maxDistance;
  }
  static void dfs(int v, int d, int p) {
    for(Node node : graph[v]){
      
      if(node.vertex == p) continue;
      
      if(maxDistance < node.distance+d){
        farthestNode = node.vertex;
        maxDistance = node.distance+d;
      }
      dfs(node.vertex, node.distance+d, v);
    }
  }

  static class Node {
    int vertex;
    int distance;

    Node(int v, int d) {
      this.vertex = v;
      this.distance = d;
    }
  }
}
