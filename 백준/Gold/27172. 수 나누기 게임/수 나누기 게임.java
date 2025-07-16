import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static Map<Integer, Integer> map = new HashMap<>();
  static int[] scores;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    scores = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      map.put(Integer.parseInt(st.nextToken()), i);
    }

    solve();
    StringBuilder sb = new StringBuilder();

    for(int num : scores){
      sb.append(num).append(" ");
    }

    System.out.print(sb);
  }

  static void solve(){
    final int max = 1_000_000;
    for(int cur : map.keySet()){
      int multiplier = 2;
      while(cur * multiplier <= max){
        if(map.containsKey(cur * multiplier)){
          scores[map.get(cur * multiplier)]--;
          scores[map.get(cur)]++;
        }
        multiplier++;
      }
    }
  }
}