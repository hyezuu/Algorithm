import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public BigInteger[] solution(int n, String[] arr) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] crr = arr[i].toCharArray();
            for (int j = 0; j < arr[i].length(); j++) {
                if (!Character.isDigit(crr[j])) {
                    sb.append(" ");
                }
                else {
                    sb.append(crr[j]);
                    len++;
                }
            }
            sb.append(" ");
        }
        String[] str = sb.toString().split(" ");
        BigInteger[] nums = new BigInteger[str.length];
        for (int i = 0; i < str.length; i++) {
            if(!str[i].isEmpty()){
                nums[i] = new BigInteger(str[i]);
            }
            else nums[i] = new BigInteger("-1");
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        for(BigInteger a :T.solution(n, arr)){
            if(!a.toString().equals("-1")) {
                bw.write(a + "\n");
            }
        }
        bw.flush();
    }
}
