import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static final long MOD = 1234567891L;
  static final long BASE = 31L;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());
    String s = br.readLine();

    long hash = 0;
    long pow = 1;

    for (int i = 0; i < L; i++) {
      long v = s.charAt(i) - 'a' + 1;
      hash = (hash + (v * pow) % MOD) % MOD;
      pow = (pow * BASE) % MOD;
    }
    System.out.print(hash);
  }
}
