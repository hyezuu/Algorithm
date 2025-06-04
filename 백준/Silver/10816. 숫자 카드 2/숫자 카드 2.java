import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static Map<Integer, Integer> map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      map.put(tmp, map.getOrDefault(tmp, 0) + 1);
    }

    M = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      sb.append(map.getOrDefault(tmp, 0)).append(" ");
    }

    System.out.println(sb);
  }
}