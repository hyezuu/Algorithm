import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static long[] A, B;
  static int T, N, M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());
    N = Integer.parseInt(br.readLine());
    A = new long[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    B = new long[M + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= M; i++) {
      B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
    }

    br.close();

    System.out.print(solve());
  }

  static long solve() {
    Map<Long, Long> partB = new HashMap<>();
    long cnt = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 1 + i; j <= M; j++) {
        partB.compute(B[j] - B[i], (k, v) -> v == null ? 1 : v + 1);
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 1 + i; j <= N; j++) {
        long target = T- (A[j] - A[i]);
        if(partB.containsKey(target)) {
          cnt+= partB.get(target);
        }
      }
    }
    return cnt;
  }
}