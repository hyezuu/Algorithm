import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while(T-- > 0){
      int sum = 0;
      int cnt = 0;
      for(char c : br.readLine().toCharArray()){
        if(c == 'X'){
          cnt = 0;
          continue;
        }
        cnt ++;
        sum += cnt;
      }
      sb.append(sum).append("\n");
    }

    System.out.print(sb);
  }
}
