import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m, r;
  static int[][] board;
  static char[][] result;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    result = new char[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken()) - 1;
        result[i][j] = 'S';
      }
    }
    count = 0;

    for (int i = 0; i < r*2; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;

      if (i % 2 == 0) {
        char direction = st.nextToken().charAt(0);
        offense(y, x, direction);
      } else {
        defense(y, x);
      }
    }

    System.out.println(count);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }

  static void offense(int y, int x, char direction) {
//    if(result[y][x] == 'F') return;

    int endY = y;
    int endX = x;

    if (direction == 'E') {
      //3 + 2 x++
      //x--
      //y--
      //y++
      endX = Math.min(endX + board[y][x], m - 1);
      for(int i=x; i<=endX; i++) {
        if(result[y][i] == 'S') {
          result[y][i] = 'F';
          count++;
          offense(y, i, direction);
        }
      }
    }
    if (direction == 'W') {
      endX = Math.max(endX - board[y][x], 0);
      for(int i=endX; i<=x; i++) {
        if(result[y][i] == 'S') {
          result[y][i] = 'F';
          count++;
          offense(y, i, direction);
        }
      }
    }
    if (direction == 'S') {
      endY = Math.min(endY + board[y][x], n - 1);
      for(int i=y; i<=endY; i++) {
        if(result[i][x] == 'S') {
          result[i][x] = 'F';
          count++;
          offense(i, x, direction);
        }
      }
    }
    if (direction == 'N') {
      endY = Math.max(endY - board[y][x], 0);
      for(int i=endY; i<=y; i++) {
        if(result[i][x] == 'S') {
          result[i][x] = 'F';
          count++;
          offense(i, x, direction);
        }
      }
    }
  }

  static void defense(int y, int x) {
    result[y][x] = 'S';
  }
}
