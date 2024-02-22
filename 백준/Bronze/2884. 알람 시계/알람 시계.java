import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer time = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(time.nextToken());
        int m = Integer.parseInt(time.nextToken());
        int t = h*60+m-45;
        if(t<0){
            t+=60*24;
        }
        System.out.printf("%d %d",t/60,t%60);
    }
}
