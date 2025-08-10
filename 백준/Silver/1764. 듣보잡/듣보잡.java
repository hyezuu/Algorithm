import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Set<String> set = new HashSet<>();
    Set<String> answer = new TreeSet<>();

    for(int i=0; i<N; i++){
      set.add(br.readLine());
    }

    for(int i=0; i<M; i++){
      String str = br.readLine();
      if(!set.add(str)){
        answer.add(str);
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append(answer.size()).append("\n");

    for(String s : answer){
      sb.append(s).append("\n");
    }

    System.out.print(sb);
  }
}