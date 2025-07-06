import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] alphabet = new int[26];

    String word = br.readLine();

    Arrays.fill(alphabet, -1);

    for(int i = 0; i < word.length(); i++) {
      int seq = word.charAt(i) - 'a';
      if(alphabet[seq] == -1) alphabet[seq] = i;
    }

    StringBuilder sb = new StringBuilder();
    
    for(int a : alphabet) {
      sb.append(a).append(" ");
    }

    System.out.println(sb);
  }
}
