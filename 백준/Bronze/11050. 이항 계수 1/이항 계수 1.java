import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, K;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.print(nCr(N, K));
  }
  
  static int nCr(int n, int r) {
    return factorial(n)/(factorial(r)*factorial(n-r));
  }
  
  static int factorial(int n) {
    if (n<=1) return 1;
    return n*factorial(n-1);
  }
}
