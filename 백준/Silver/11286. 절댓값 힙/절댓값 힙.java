import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a) == Math.abs(b)) {
        return a - b;
      } else {
        return Math.abs(a) - Math.abs(b);
      }
    });
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
        continue;
      }
      pq.offer(x);
    }
    System.out.print(sb);
  }
}
