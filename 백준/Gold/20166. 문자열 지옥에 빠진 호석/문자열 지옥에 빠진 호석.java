import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static char[][] board;
  static Map<String, Integer> map;
  static int[] dy = {-1, 0, 1, 1, -1, -1, 0, 1};
  static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int n, m, k;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new char[n][m];

    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
    }

    sb = new StringBuilder();
    map = new HashMap<>();

    for (int i = 0; i < k; i++) {
      String tmp = br.readLine();
      solve(tmp);
    }
    System.out.println(sb.toString());
  }

  static void solve(String answer) {
    if(map.containsKey(answer)){
      sb.append(map.get(answer)).append('\n');
      return;
    }

    if (answer.length() == 1) {
      int count = 0;
      char target = answer.charAt(0);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (board[i][j] == target) {
            count++;
          }
        }
      }
      sb.append(count).append('\n');
      map.put(answer, count);
      return;
    }


    int[][][] dp = new int[n][m][answer.length()+1];
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == answer.charAt(0)) {
          dp[i][j][0] = 1;
        }
      }
    }

    for (int idx = 1; idx < answer.length(); idx++) {
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
          if (dp[y][x][idx-1] > 0) {

            for (int d = 0; d < 8; d++) {
              int ny = (y + dy[d] + n) % n;
              int nx = (x + dx[d] + m) % m;

              if (board[ny][nx] == answer.charAt(idx)) {
                dp[ny][nx][idx] += dp[y][x][idx-1];
              }
            }
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cnt += dp[i][j][answer.length()-1];
      }
    }
    sb.append(cnt).append('\n');
    map.put(answer, cnt);
  }
}