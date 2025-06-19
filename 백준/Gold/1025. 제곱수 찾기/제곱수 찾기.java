import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] table;
  static long max = -1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    table = new int[N][M];

    for(int i=0; i<N; i++){
      String tmp = br.readLine();
      for(int j=0; j<M; j++){
        table[i][j] = tmp.charAt(j) - '0';
      }
    }

    solve();
    System.out.println(max);
  }

  static void solve(){
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        for(int k=-N+1; k<N; k++){
          for(int l=-M+1; l<M; l++){
            dfs(i, j, 0, k, l);
          }
        }
      }
    }
  }

  static void dfs(int y, int x, long total, int seqY, int seqX){
    if(y < 0 || x < 0 || y >= N || x >= M) return;
    long newTotal = total*10+table[y][x];
    if(isSquare(newTotal)){
      max = Math.max(newTotal, max);
    }
    if(seqY == 0 && seqX == 0) return;
    dfs(y+seqY, x+seqX, newTotal, seqY, seqX);
  }

  static boolean isSquare(long n) {
    if(n==0) return true;
    long sqrt = (long) Math.sqrt(n);
    return sqrt * sqrt == n;
  }
}