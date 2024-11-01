import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = 101;

        long[] dp = new long[k];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<k; i++){
            dp[i] = dp[i-3]+dp[i-2];
        }

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }
}
