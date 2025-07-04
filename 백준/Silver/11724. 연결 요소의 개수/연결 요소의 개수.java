import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static List<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new List[N];

    for(int i = 0; i < N; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i = 0; i< M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      graph[a].add(b);
      graph[b].add(a);
    }

    System.out.print(solve());
  }

  static int solve(){
    int cnt = 0;
    visited = new boolean[N];
    for(int i = 0; i < N; i++){
      if(!visited[i]){
        dfs(i);
        cnt++;
      }
    }
    return cnt;
  }

  static void dfs(int node){
    visited[node] = true;

    for(int next: graph[node]){
      if(!visited[next]){
        dfs(next);
      }
    }
  }

}
