import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int remainder = k;
        int cnt = 0;
        while(remainder!=0 && --n >= 0){
            if(remainder>=coins[n]){
                cnt+= remainder/coins[n];
                remainder%=coins[n];
            }
        }
        System.out.print(cnt);
        br.close();
    }
}