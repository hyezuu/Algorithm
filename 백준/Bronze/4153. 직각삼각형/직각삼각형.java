import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String tmp;
    StringBuilder sb = new StringBuilder();
    while(!(tmp = br.readLine()).equals("0 0 0")){
      StringTokenizer st = new StringTokenizer(tmp);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      boolean flag = false;
      if(a>b && a>c) flag = a*a == b*b + c*c;
      else if(b>a && b>c) flag = b*b == a*a + c*c;
      else flag = c*c == a*a + b*b;

      sb.append(flag ? "right" : "wrong").append("\n");
    }
    System.out.print(sb);
  }
}
