import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append((countPair(n, m))).append("\n");
        }

        System.out.print(sb);
    }

    public static int countPair(int n, int m){
        int cnt = 0;
        for(int a=1 ; a< n-1; a++){
            for(int b = a+1; b< n; b++){
                int q = a*a + b*b + m;
                int d = a*b;

                if(q%d==0){cnt++;}
            }
        }
        return cnt;
    }

}
