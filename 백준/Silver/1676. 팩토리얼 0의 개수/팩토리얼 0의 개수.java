import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    System.out.print(countTrailingZeros(N));
  }

  static int countTrailingZeros(int n) {
    int count = 0;
    while (n >= 5) {
      count += n / 5;
      n /= 5;
    }
    return count;
  }
}
