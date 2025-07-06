import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> set = new TreeSet<>(
        (s1, s2) -> {
          if(s1.length() == s2.length()){
            return s1.compareTo(s2);
          }
          return s1.length() - s2.length();
        }
    );

    int N = Integer.parseInt(br.readLine());

    for(int i=0; i<N; i++){
      String s = br.readLine();
      set.add(s);
    }

    for(String s : set){
      System.out.println(s);
    }
  }
}
