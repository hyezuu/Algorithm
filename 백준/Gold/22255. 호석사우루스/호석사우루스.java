import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dx = new int[][]{{1, -1, 0, 0}, {1, -1}, {0, 0}};
  static int[][] dy = new int[][]{{0, 0, 1, -1}, {0, 0}, {1, -1}};
  static int[][] map;
  static int N, M;
  static int Sx, Sy, Ex, Ey;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Sx = Integer.parseInt(st.nextToken())-1;
    Sy = Integer.parseInt(st.nextToken())-1;
    Ex = Integer.parseInt(st.nextToken())-1;
    Ey = Integer.parseInt(st.nextToken())-1;

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(bfs());
  }

  public static int bfs() {
    boolean[][][] visited = new boolean[3][N][M];

    //if(dist[nx][ny][(current.count + 1) % 3] <= board[nx][ny] + current.cost) return;
    PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));

    q.offer(new int[]{Sx, Sy, 0, 0});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0]; //이동하기전 현재 x
      int y = cur[1]; //이동하기전 현재 y
      int cnt = cur[2]; // 몇번째로 이동했는지
      int pow = cur[3]; // 현재까지의 충격량

      for(int i=0; i<dx[(cnt+1)%3].length; i++){
        int nx = x + dx[(cnt+1)%3][i];
        int ny = y + dy[(cnt+1)%3][i];

        if(nx == Ex && ny == Ey){
          return pow;
        }

        if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
        if(map[nx][ny] == -1) continue;
        if(visited[(cnt+1)%3][nx][ny]) continue;
        visited[(cnt+1)%3][nx][ny] = true;
        q.offer(new int[]{nx, ny, cnt+1, pow+map[nx][ny]});
      }
    }
    return -1;
  }
}