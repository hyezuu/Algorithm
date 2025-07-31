import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static char[][] map;
  static int[] parent;
  static Map<Character, int[]> direction = Map.of(
      'L', new int[]{0, -1},
      'R', new int[]{0, 1},
      'U', new int[]{-1, 0},
      'D', new int[]{1, 0});
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    System.out.print(solve());
  }

  static int solve() {
    parent = new int[N * M];
    visited = new boolean[N * M];

    for (int i = 0; i < N * M; i++) {
      parent[i] = i;
    }

    //i*m+j
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int idx = i * M + j;
        if(visited[idx]) continue;
        dfs(i, j);
      }
    }

    int cnt = 0;

    for (int i = 0; i < N * M; i++) {
      if(parent[i] == i) cnt++;
    }
    return cnt;
  }

  static void dfs(int fromY, int fromX) {
    int fromIdx = fromY * M + fromX;
    if(visited[fromIdx]) return;
    visited[fromIdx] = true;

    //to의 부모가 from일때까지, 또는 아닌경우
    int[] dir = direction.get(map[fromY][fromX]);
    int toY = fromY + dir[0];
    int toX = fromX + dir[1];

    if(toY < 0 || toY >= N || toX < 0 || toX >= M) return;

    int toIdx = toY * M + toX;
    union(toIdx, fromIdx);
    if (!visited[toIdx]) {
      dfs(toY, toX);
    }
  }

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int x, int y) {
    int px = find(x);
    int py = find(y);

    if (px == py) {
      return;
    } else {
      parent[px] = py;
    }
  }
}