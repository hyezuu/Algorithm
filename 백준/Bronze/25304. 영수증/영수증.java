import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        for(int i=0; i<cnt;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            sum-=p*n;
        }
        System.out.print(sum==0?"Yes":"No");
    }
}
