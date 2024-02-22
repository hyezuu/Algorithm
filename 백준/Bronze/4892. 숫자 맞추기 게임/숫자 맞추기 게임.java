import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)break;
            bw.write(cnt+". ");
            int a = 3*n;
            bw.write(a%2==0?"even ":"odd ");
            a = (a%2==0? a/2:(a+1)/2)*3;
            bw.write(a/9+"");
            bw.write("\n");
            cnt++;
        }

        bw.flush();

    }
}
