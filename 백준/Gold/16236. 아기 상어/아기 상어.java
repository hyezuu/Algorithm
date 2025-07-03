import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, -1, 0, 1};
  static int[][] map;
  static int N;
  static int[] start;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 9){
          start = new int[]{i, j};
          map[i][j] = 0;
        }
      }
    }
    System.out.print(solve());
  }

  //먼저 맵 전체를 확인하면서 먹을 수 있는 물고기를 확인한다. 매번수행 (위, 왼 순서로)
  //있다면 위, 왼쪽 순서로 찾으며 가져온다
  static int solve() {
    int time = 0;
    int size = 2;
    int count = 0;

    while (true) {
      int[] fish = findFish(start[0], start[1], size);
      if (fish == null) return time;
      //먹음
      map[fish[0]][fish[1]] = 0;
      count++;
      if(count == size){
        size++;
        count = 0;
      }
      //시간
      time += fish[2];
      //시작점 바꿔줌
      start = new int[]{fish[0], fish[1]};
    }
  }

  static int[] findFish(int y, int x, int size){
    boolean[][] visited = new boolean[N][N];
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{y, x, 0});
    visited[y][x] = true;

    int minDist = Integer.MAX_VALUE;
    int fishY = -1, fishX = -1;

    while (!q.isEmpty()){
      int[] cur = q.poll();

      if(cur[2] > minDist) continue;
      if(map[cur[0]][cur[1]] > 0 && map[cur[0]][cur[1]] <size) {
        if(cur[2] < minDist ||
            cur[0] < fishY ||
            cur[0] == fishY && cur[1] < fishX
        ){
          minDist = cur[2];
          fishY = cur[0];
          fishX = cur[1];
        }
      }

      for(int i = 0; i < 4; i++){
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
        if(map[ny][nx] > size) continue;
        if(visited[ny][nx]) continue;
        visited[ny][nx] = true;

        q.offer(new int[]{ny, nx, cur[2]+1});
      }
    }
    return fishY == -1 ? null : new int[]{fishY, fishX, minDist};
  }
}
