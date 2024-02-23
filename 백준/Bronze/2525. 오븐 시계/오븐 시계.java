import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer time = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(time.nextToken());
        int m = Integer.parseInt(time.nextToken());
        int t = Integer.parseInt(br.readLine());
        int a = h*60+m+t;
        System.out.printf("%d %d",(a/60)%24,a%60);
    }
}
