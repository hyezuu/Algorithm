import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static Map<Long, Integer> patterns = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i=0; i<N; i++) {
      Long pattern = Long.parseLong(br.readLine(), 2);
      patterns.compute(pattern, (k, v) -> v == null ? 1 : v + 1);
    }

    K = Integer.parseInt(br.readLine());
    br.close();

    System.out.print(solve());
  }

  static int solve() {
    int maxRows = 0;

    for (Long pattern : patterns.keySet()){
      int count = patterns.get(pattern);
      int needed = M - Long.bitCount(pattern);

      if(needed <= K && (K - needed) %  2 == 0){
        maxRows = Math.max(maxRows, count);
      }
    }
    return maxRows;
  }
}