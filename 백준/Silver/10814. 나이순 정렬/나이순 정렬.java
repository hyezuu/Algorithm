import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Map<Integer, List<String>> map = new TreeMap<>();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      map.computeIfAbsent(num, k -> new ArrayList<>()).add(name);
    }

    StringBuilder sb = new StringBuilder();

    for (int key : map.keySet()) {
      for(String name : map.get(key)) {
        sb.append(key).append(" ").append(name).append("\n");
      }
    }

    System.out.print(sb);
  }
}