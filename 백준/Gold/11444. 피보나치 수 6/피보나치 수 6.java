import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] mat = {{1, 1}, {1, 0}};
  static final int MOD = 1_000_000_007;
  static long N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Long.parseLong(st.nextToken());

    System.out.print(solve());
  }

  static int solve() {
    int[][] mat = dfs(N);

    return mat[1][0];
  }

  static int[][] dfs(long a) {
    if (a == 0) {
      return new int[][]{{1, 0}, {0, 1}};
    }
    if (a == 1) {
      return mat;
    }

    int[][] half = dfs(a >> 1);
    int[][] result = product(half, half);
    if (a % 2 == 1) {
      result = product(result, mat);
    }

    return result;
  }

  static int[][] product(int[][] mat1, int[][] mat2) {
    int[][] res = new int[2][2];

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        long sum = 0;
        for(int k = 0; k < 2; k++) {
          sum = sum + (long)mat1[i][k] * mat2[k][j];
        }
        res[i][j] = (int)(sum%MOD);
      }
    }

    return res;
  }
}
