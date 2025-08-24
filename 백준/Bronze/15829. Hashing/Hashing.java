import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());
    String str = br.readLine();
    br.close();

    long total = 0;

    for (int i = 0; i < L; i++) {
      total += (long) (((long) (str.charAt(i) - 'a' + 1)*Math.pow(31, i))%1234567891);
    }
    System.out.print(total%1234567891);
  }
}
