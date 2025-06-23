import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] map;
  static int[] dy = {0, 0, 1, -1};
  static int[] dx = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(solve());
  }

  static int solve() {
    int[][] visited = new int[N][N];
    Queue<int[]> q = new LinkedList<>();

    int islandNum = 2;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(map[i][j] == 1){
          dfs(i, j, islandNum++);
        }
      }
    }

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(map[i][j] >= 2){
          q.offer(new int[]{i, j, map[i][j], 0});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int y = cur[0], x = cur[1], num = cur[2], dis = cur[3];
      for (int k = 0; k < 4; k++) {
        int ny = y + dy[k];
        int nx = x + dx[k];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (map[ny][nx] == 0 && visited[ny][nx] != num) {
          q.offer(new int[] {ny, nx, num, dis + 1});
          visited[ny][nx] = num;
        }
        else if(map[ny][nx] != 0 && num != map[ny][nx]){
          return dis;
        }
      }
    }
    return -1;
  }

  static void dfs(int y, int x, int islandNum) {
    if(y < 0 || y >= N || x < 0 || x >= N || map[y][x] != 1) return;

    map[y][x] = islandNum;

    for(int i = 0; i < 4; i++){
      dfs(y + dy[i], x + dx[i], islandNum);
    }
  }
}