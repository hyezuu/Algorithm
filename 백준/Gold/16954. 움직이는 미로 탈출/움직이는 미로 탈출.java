import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  static char[][] board;
  static int[] dy = {1, 1, 1, 0, 0, 0, -1, -1, -1};
  static int[] dx = {1, 0, -1, 1, 0, -1, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    board = new char[8][8];

    for (int i = 0; i < 8; i++) {
      board[i] = br.readLine().toCharArray();
    }

    System.out.print(solve());
  }

  static int solve() {
    Queue<Node> q = new ArrayDeque<>();
    boolean[][][] visited = new boolean[8][8][9];

    q.offer(new Node(7, 0, 0));
    visited[7][0][0] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if(cur.y == 0 && cur.x == 7) return 1;
      if(cur.t >= 8) return 1;

      for(int i=0; i<9; i++){
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];
        int nt = cur.t + 1;

        if(ny < 0 || ny >= 8 || nx < 0 || nx >= 8) continue;
        if(nt > 8) continue;
        if(visited[ny][nx][nt]) continue;
        if(hasWall(ny, nx, nt)) continue;

        visited[ny][nx][nt] = true;
        q.offer(new Node(ny, nx, nt));
      }
    }
    return 0;
  }

  static boolean hasWall(int y, int x, int t) {
    int origin1 = y - t;     // 시간 t일 때의 벽 위치
    int origin2 = y - t + 1; // 이전 시간에서 내려오는 벽

    boolean now = (origin1 >= 0 && board[origin1][x] == '#');
    boolean prev = (origin2 >= 0 && board[origin2][x] == '#');

    return now || prev;
  }


  static class Node {
    int y;
    int x;
    int t;

    Node(int y, int x, int t) {
      this.y = y;
      this.x = x;
      this.t = t;
    }
  }
}
