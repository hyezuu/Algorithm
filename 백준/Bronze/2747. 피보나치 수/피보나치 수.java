import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
        br.close();
    }
    public static int fibo(int n) {
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i=2; i<=n; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];
        }
        return fibo[n];
    }
}