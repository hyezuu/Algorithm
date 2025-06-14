import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int[] dy = {0, 0, 1, -1, 0, 0};
  static int[] dx = {1, -1, 0, 0, 0, 0};
  static int L, R, C;
  static char[][][] building;
  static StringBuilder sb = new StringBuilder();
  static final String ESCAPE_MSG = "Escaped in %d minute(s).";
  static final String FAIL_MSA = "Trapped!";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    while (L != 0 && R != 0 && C != 0) {
      building = new char[L][R][C];
      int[] S = new int[3];

      for(int i=0; i<L; i++){
        for(int j=0; j<R; j++){
          String line = br.readLine();
          for(int k=0; k<C; k++){
            building[i][j][k] = line.charAt(k);
            if(building[i][j][k] == 'S'){
              S = new int[]{i, j, k, 0};
            }
          }
        }
        br.readLine();
      }
      int answer = bfs(S);
      sb.append(answer == -1 ? FAIL_MSA : String.format(ESCAPE_MSG, answer))
          .append("\n");

      st = new StringTokenizer(br.readLine());
      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
    }
    System.out.println(sb.toString());
  }

  static int bfs(int[] S) {
    Queue<int[]> q = new LinkedList<>();
    boolean[][][] visited = new boolean[L][R][C];
    q.offer(S);
    visited[S[0]][S[1]][S[2]] = true;

    while (!q.isEmpty()) {
      int[] s = q.poll();
      int z = s[0], y = s[1], x = s[2], t = s[3];

      for(int i=0; i<6; i++){
        int nz = z + dz[i];
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(nx < 0 || ny < 0 || nz < 0 || nz >= L || ny >=R || nx >=C) continue;
        if(visited[nz][ny][nx]) continue;
        if(building[nz][ny][nx] == '#') continue;
        if(building[nz][ny][nx] == 'E') return t+1;
        visited[nz][ny][nx] = true;
        q.offer(new int[]{nz, ny, nx, t+1});
      }
    }
    return -1;
  }
}