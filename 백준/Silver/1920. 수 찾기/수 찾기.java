import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static Set<Integer> set;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    set = new HashSet<>();

    for(int i=0; i<N; i++){
      set.add(Integer.parseInt(st.nextToken()));
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    sb = new StringBuilder();

    for(int i=0; i<M; i++){
      search(Integer.parseInt(st.nextToken()));
    }

    System.out.println(sb.toString());
  }

  static void search(int target){
    sb.append(set.contains(target) ? "1" : "0").append("\n");
  }
}