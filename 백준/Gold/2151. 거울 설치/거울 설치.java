import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static int N;
  static char[][] map;
  static int[][] doors;
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, -1, 0, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    doors = new int[2][2];
    int idx = 0;

    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = tmp.charAt(j);
        if (map[i][j] == '#') {
          doors[idx++] = new int[]{i, j};
        }
      }
    }
    System.out.println(solve());
  }

  static int solve() {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    boolean[][][] visited = new boolean[4][N][N];

//    for(int i=0; i<N; i++){
//      Arrays.fill(visited[i], -1);
//    }
    
    map[doors[0][0]][doors[0][1]] = '*';

    for (int i = 0; i < 4; i++) {
      int ny = doors[0][0] + dy[i];
      int nx = doors[0][1] + dx[i];

      if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
      if (map[ny][nx] == '*') continue;

      //카운트, 방향, y, x
      pq.offer(new int[]{0, i, doors[0][0], doors[0][1]});
    }

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int cnt = cur[0];
      int dir = cur[1];
      int y = cur[2];
      int x = cur[3];

      //방문하지 않은 문을 만나면 cnt 리턴
      if (map[y][x] == '#') {
        return cnt;
      }

      int ny = y + dy[dir];
      int nx = x + dx[dir];

      if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
      if (map[ny][nx] == '*') continue;
      if (visited[dir][ny][nx]) continue;
      visited[dir][ny][nx] = true;

      pq.offer(new int[]{cnt, dir, ny, nx});

      if(map[ny][nx] == '!'){
        //반시계방향
        pq.offer(new int[]{cnt+1, (dir+1)%4, ny, nx});
        //시계방향
        pq.offer(new int[]{cnt+1, (dir+3)%4, ny, nx});
      }
    }
    return 0;
  }
}
