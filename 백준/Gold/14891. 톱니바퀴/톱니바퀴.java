import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int[][] status;
  static int[] dirs;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    status = new int[4][8];

    //N극은 0, S극은 1
    for (int i = 0; i < 4; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < 8; j++) {
        status[i][j] = tmp.charAt(j) - '0';
      }
    }

    int K = Integer.parseInt(br.readLine());

    //극이 서로 같으면 멈추고, 다르면 반대방향으로 회전한다.
    for (int i = 0; i < K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());

      solve(num, dir);
    }

    int total = 0;

    for (int i = 0; i < 4; i++) {
      total += status[i][0] * (1 << i);
    }

    System.out.println(total);
  }

  //1이면 시계방향, -1이면 반시계
  static void solve(int num, int dir) {
    dirs = new int[4];
    dirs[num] = dir;

    for (int i = num - 1; i >= 0; i--) {
      if (status[i][2] != status[i + 1][6]) {
        dirs[i] = -dirs[i+1];
      }
      else break;
    }
    for (int i = num + 1; i < 4; i++) {
      if (status[i][6] != status[i - 1][2]) {
        dirs[i] = -dirs[i-1];
      }
      else break;
    }

    for(int i=0; i<4; i++) {
      if(dirs[i] != 0) {
        rotate(i, dirs[i]);
      }
    }
  }

  static void rotate(int num, int dir) {
    int[] temp = Arrays.copyOf(status[num], 8);
    for (int i = 0; i < 8; i++) {
      status[num][i] = temp[(i - dir + 8) % 8];
    }
  }
}