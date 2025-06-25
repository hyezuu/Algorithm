import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static long B;
  static int[][] matrix;
  final static int MOD = 1000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    B = Long.parseLong(st.nextToken());

    matrix = new int[N][N];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
      }
    }

    int[][] result = dfs(B);

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int[][] dfs(long B){
    if(B == 0) {
      int[][] tmp = new int[N][N];
      for(int i=0; i<N; i++){
        tmp[i][i] = 1;
      }
      return tmp;
    }
    if(B == 1) return matrix;

    int[][] half = dfs(B>>1);
    int[][] result = product(half, half);

    if(B%2 == 1) {
      result = product(result, matrix);
    }

    return result;
  }

  static int[][] product(int[][] mat1, int[][]mat2){
    int[][] mat = new int[N][N];
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        int sumProduct = 0;
        for(int k=0; k<N; k++){
          sumProduct = (sumProduct + mat1[i][k] * mat2[k][j]) % MOD;
        }
        mat[i][j] = sumProduct;
      }
    }
    return mat;
  }
}