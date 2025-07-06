import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while(T-- > 0){
      Stack<Character> stack = new Stack<>();
      boolean isVps = true;
      for(char c : br.readLine().toCharArray()){

        if(c=='('){
          stack.push(c);
        } else if(stack.isEmpty()) {
          isVps = false;
          break;
        } else stack.pop();
      }
      sb.append(isVps && stack.isEmpty() ? "YES\n" : "NO\n");
    }

    System.out.print(sb);
  }
}
