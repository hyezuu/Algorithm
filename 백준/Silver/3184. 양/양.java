import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static char[][] arr;
  static int r, c;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new char[r][c];

    for(int i=0; i<r; i++){
      arr[i] = br.readLine().toCharArray();
    }
    System.out.print(bfs());
  }

  static String bfs() {
    Queue<int[]> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[r][c];

    int totalO = 0;
    int totalV = 0;

    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (!visited[i][j] && (arr[i][j] == 'o' || arr[i][j] == 'v')) {
          q.offer(new int[]{i, j});
          visited[i][j] = true;
        }

        int curO = 0;
        int curV = 0;

        while (!q.isEmpty()) {
          int[] cur = q.poll();

          int curY = cur[0];
          int curX = cur[1];

          if(arr[curY][curX] == 'v') curV++;
          if(arr[curY][curX] == 'o')curO++;

          for(int k = 0; k < 4; k++) {
            int y = curY + dy[k];
            int x = curX + dx[k];

            if(y >= 0 && y < r && x >= 0 && x < c && !visited[y][x] && arr[y][x] != '#') {
              q.offer(new int[]{y, x});
              visited[y][x] = true;
            }
          }
        }
        if(curV >= curO) totalV += curV;
        else totalO += curO;
      }
    }
    return totalO + " " + totalV;
  }
}
