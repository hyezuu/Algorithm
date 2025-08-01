import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<int[]> q = new ArrayDeque<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while(T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      for(int i = 0; i < N; i++) {
        int num = Integer.parseInt(st.nextToken());
        q.offer(new int[]{num, i});
        pq.offer(num);
      }

      int cnt = 1;

      while (!pq.isEmpty()) {
        int next = pq.poll();

        while (true){
          int[] poll = q.poll();
          if(poll[0] != next) {
            q.offer(poll);
            continue;
          }
          if(poll[1] == M) sb.append(cnt).append('\n');
          break;
        }
        cnt++;
      }
    }
    System.out.print(sb);
  }
}