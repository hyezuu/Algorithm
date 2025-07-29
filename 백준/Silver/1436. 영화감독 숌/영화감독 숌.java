import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if (N <= 6) {
      System.out.println((N == 1 ? "" : N - 1) + "666");
    } else {
      int cnt = 6;
      long num = 6660;

      while (true) {
        if (String.valueOf(num).contains("666")) {
          cnt++;
        }
        if (cnt == N) {
          System.out.print(num);
          break;
        }
        num++;
      }
    }
  }
}