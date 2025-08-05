import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    System.out.print(solve(N));
  }

  private static int solve(int N){
    int i = 1;
    int t = 1;
    while (true){
      if(i >= N) return t;
      i += t++*6;
    }
  }
}