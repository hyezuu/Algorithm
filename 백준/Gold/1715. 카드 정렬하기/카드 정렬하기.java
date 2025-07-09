import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static PriorityQueue<Integer> pq = new PriorityQueue<>();
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for(int i=0; i<N; i++) {
      //10, 20, 40
      pq.offer(Integer.parseInt(br.readLine()));
    }

    System.out.print(solve());;
  }

  static long solve(){
    if(pq.size() == 1) return 0;

    long cur = 0;

    while (pq.size() > 1){
      int first = pq.poll();
      int second = pq.poll();

      pq.offer(first+second);
      cur += first+second;
    }

    return cur;
  }
}