import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c0 = br.readLine().toCharArray();
        char[] c1 = br.readLine().toCharArray();

        bw.write(T.solution(c0, c1));
        bw.flush();
    }

    public String solution(char[] c0, char[] c1) {
        int count = 0;
        int[] arr = new int[26];
        for (int i = 0; i <c0.length; i++) {
            arr[c0[i] - 'a']++;
        }
        for (int i = 0; i <c1.length; i++) {
            arr[c1[i] - 'a']--;
        }
        for (int num : arr) {
            count += Math.abs(num);
        }
        return count + "";
    }
}
