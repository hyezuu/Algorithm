import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[][] map;
  static int[] parent;
  static int[] dy = {0, 0, -1, 1};
  static int[] dx = {-1, 1, 0, 0};
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = getDirection(line.charAt(j));
      }
    }

    System.out.print(solve());
  }

  static int getDirection(char c) {
    switch (c) {
      case 'L': return 0;
      case 'R': return 1;
      case 'U': return 2;
      case 'D': return 3;
      default: return -1;
    }
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
        if (visited[idx]) {
          continue;
        }
        dfs(i, j);
      }
    }

    int cnt = 0;

    for (int i = 0; i < N * M; i++) {
      if (parent[i] == i) {
        cnt++;
      }
    }
    return cnt;
  }

  static void dfs(int fromY, int fromX) {
    int fromIdx = fromY * M + fromX;
    if (visited[fromIdx]) {
      return;
    }
    visited[fromIdx] = true;

    //to의 부모가 from일때까지, 또는 아닌경우
    int dir = map[fromY][fromX];
    int toY = fromY + dy[dir];
    int toX = fromX + dx[dir];

    if (toY < 0 || toY >= N || toX < 0 || toX >= M) {
      return;
    }

    int toIdx = toY * M + toX;
    union(toIdx, fromIdx);
    dfs(toY, toX);

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