import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static long[] patterns;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    patterns = new long[N];

    for(int i=0; i<N; i++) {
      patterns[i] = Long.parseLong(br.readLine(), 2);
    }

    K = Integer.parseInt(br.readLine());
    br.close();

    System.out.print(solve());
  }

  static int solve() {
    boolean[] processed = new boolean[N];
    int maxRows = 0;

    for (int i = 0; i < N; i++) {
      if(processed[i]) continue;
      processed[i] = true;
      long pattern = patterns[i];
      int needed = M - Long.bitCount(pattern);

      if (needed <= K && (K - needed) % 2 == 0) {
        int count = 0;
        for (int j = i; j < N; j++) {
          if (patterns[i] == patterns[j]) {
            processed[j] = true;
            count++;
          }
        }
        maxRows = Math.max(maxRows, count);
      }
    }
    return maxRows;
  }
}