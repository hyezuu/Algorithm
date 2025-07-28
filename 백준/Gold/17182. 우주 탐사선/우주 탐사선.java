import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, K;
  static int[][] time;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    time = new int[N][N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        time[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();

    floydWarshall();

    visited = new boolean[N];
    visited[K] = true;

    dfs(K, 1, 0);

    System.out.print(min);
  }
  static void floydWarshall() {
    for(int k = 0; k < N; k++) {
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
        }
      }
    }
  }

  static void dfs(int current, int count, int sum) {
    if(count == N){
      min = Math.min(min, sum);
      return;
    }
    for(int next = 0; next < N; next++) {
      if(!visited[next]) {
        if(sum + time[current][next] > min) continue;
        visited[next] = true;
        dfs(next, count + 1, sum + time[current][next]);
        visited[next] = false;
      }
    }
  }
}
