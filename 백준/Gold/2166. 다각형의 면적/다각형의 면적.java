import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] point;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    point = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      point[i][0] = Integer.parseInt(st.nextToken());
      point[i][1] = Integer.parseInt(st.nextToken());
    }

    System.out.printf("%.1f", solve());
  }

  static double solve() {
    long sum = 0;

    for (int i = 0; i < N; i++) {
      sum += (long) point[i][0] * point[(i + 1) % N][1];
      sum -= (long) point[i][1] * point[(i + 1) % N][0];
    }

    return Math.abs(sum) / 2.0;
  }
}