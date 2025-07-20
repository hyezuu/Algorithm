import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static StringBuilder sb = new StringBuilder();
  static int N = 0;
  static int K = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    sb.append('<');

    solve();

    sb.append('>');

    System.out.print(sb);
  }

  private static void solve() {
    Queue<Integer> q = new ArrayDeque<>();

    for(int i = 1; i <= N; i++) {
      q.offer(i);
    }

    int cnt = 0;
    while(!q.isEmpty()) {
      if(++cnt%K == 0) sb.append(q.poll()).append(", ");
      else q.offer(q.poll());
    }

    sb.delete(sb.length()-2, sb.length());
  }
}