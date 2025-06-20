import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, K, R;
  static int[][] cows;
  static List<int[]>[][] rows;
  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    rows = new List[N][N];

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        rows[i][j] = new LinkedList<>();
      }
    }

    for(int i=0; i<R; i++){
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken())-1;
      int c = Integer.parseInt(st.nextToken())-1;
      int r2 = Integer.parseInt(st.nextToken())-1;
      int c2 = Integer.parseInt(st.nextToken())-1;

      rows[r][c].add(new int[]{r2, c2});
      rows[r2][c2].add(new int[]{r, c});
    }

    cows = new int[K][2];

    for(int i=0; i<K; i++){
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken())-1;
      int x = Integer.parseInt(st.nextToken())-1;

      cows[i] = new int[]{y, x};
    }

    System.out.println(solve());
  }

  static int solve(){
    int pair = 0;
    for(int i=0; i<K; i++){
      for(int j=i+1; j<K; j++){
        if(!canMeet(i, j)) pair++;
      }
    }
    return pair;
  }

  static boolean canMeet(int i, int j){
    int[] from = cows[i];
    int[] to = cows[j];

    Queue<int[]> q = new LinkedList<>();
    q.offer(cows[i]);
    boolean[][] visited = new boolean[N][N];
    visited[from[0]][from[1]] = true;

    while(!q.isEmpty()){
      int[] now = q.poll();
      int y = now[0];
      int x = now[1];

      for(int k=0; k<4; k++){
        int ny = y+dy[k];
        int nx = x+dx[k];
        boolean isRoad = false;

        if(ny<0 || ny>=N || nx<0 || nx>=N || visited[ny][nx]) continue;
        for(int[] row : rows[y][x]){
          if(ny == row[0] && nx == row[1]){
            isRoad = true;
            break;
          }
        }
        if(isRoad) continue;
        if(ny == to[0] && nx == to[1]) return true;
        q.offer(new int[]{ny, nx});
        visited[ny][nx] = true;
      }
    }
    return false;
  }
}
