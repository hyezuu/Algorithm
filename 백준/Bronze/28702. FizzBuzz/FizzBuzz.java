import java.io.*;
import java.util.*;

public class Main {
  static final String FIZZ = "Fizz";
  static final String BUZZ = "Buzz";
  static final String FIZZBUZZ = FIZZ + BUZZ;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = 0;
    for(int i=0; i<3; i++){
      String str = br.readLine();
      if(!FIZZBUZZ.contains(str)) {
        num = Integer.parseInt(str) + 3 - i;
      }
    }

    System.out.print(
        num%15==0 ? FIZZBUZZ :
            num%3==0 ? FIZZ : num%5==0 ? BUZZ
                : num+" "
    );
  }

}
