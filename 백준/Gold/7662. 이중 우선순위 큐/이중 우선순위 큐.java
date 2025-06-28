import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  static TreeMap<Integer, Integer> map;
  static final String EMPTY = "EMPTY";

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      int k = Integer.parseInt(br.readLine());
      map = new TreeMap<>();

      for (int i = 0; i < k; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        char op = st.nextToken().charAt(0);
        int num = Integer.parseInt(st.nextToken());

        handle(op, num);
      }
      if(map.isEmpty()) sb.append(EMPTY).append("\n");
      else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
    }
    System.out.print(sb);
  }
  static void handle(char op, int num) {
    if (op == 'I') {
      map.put(num, map.getOrDefault(num, 0) + 1);
    } else {
      if(map.isEmpty()) return;
      map.compute(num == 1 ? map.lastKey() : map.firstKey(),
          (key, value) ->
              value == null || value <= 1 ? null : value -1);
    }
  }
}