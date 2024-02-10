import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            char[] c0 = stk.nextToken().toCharArray();
            char[] c1 = stk.nextToken().toCharArray();
            Arrays.sort(c0);
            Arrays.sort(c1);
            if (String.valueOf(c0).equals(String.valueOf(c1))) {
                sb.append("Possible").append("\n");
            } else sb.append("Impossible").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
