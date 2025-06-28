import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static PriorityQueue<Integer> minPq;
  static PriorityQueue<Integer> maxPq;
  static Map<Integer, Integer> map;
  static final String EMPTY = "EMPTY";
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (T-- > 0){
      int k = Integer.parseInt(br.readLine());
      minPq = new PriorityQueue<>();
      maxPq = new PriorityQueue<>(Comparator.reverseOrder());
      map = new HashMap<>();

      for(int i = 0; i < k; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        char op = st.nextToken().charAt(0);
        int num = Integer.parseInt(st.nextToken());

        if(op == 'I'){
          minPq.offer(num);
          maxPq.offer(num);
          map.put(num, map.getOrDefault(num, 0) + 1);
        }
        else{
          if(num == -1){
            while (!minPq.isEmpty() && map.get(minPq.peek()) == 0){
              minPq.poll();
            }
            if(!minPq.isEmpty()){
              int val = minPq.poll();
              map.put(val, map.get(val) - 1);
            }
          }
          else {
            while (!maxPq.isEmpty() && map.get(maxPq.peek()) == 0){
              maxPq.poll();
            }
            if(!maxPq.isEmpty()){
              int val = maxPq.poll();
              map.put(val, map.get(val) - 1);
            }
          }
        }
      }
      while (!maxPq.isEmpty() && map.getOrDefault(maxPq.peek(), 0) == 0){
        maxPq.poll();
      }
      while (!minPq.isEmpty() && map.getOrDefault(minPq.peek(), 0) == 0){
        minPq.poll();
      }

      if(maxPq.isEmpty() && minPq.isEmpty()){
        sb.append(EMPTY).append("\n");
      }
      else{
        sb.append(maxPq.isEmpty() ? minPq.peek() : maxPq.peek())
            .append(" ")
            .append(minPq.isEmpty() ? maxPq.peek() : minPq.peek())
            .append("\n");
      }
    }
    System.out.println(sb);
  }
}