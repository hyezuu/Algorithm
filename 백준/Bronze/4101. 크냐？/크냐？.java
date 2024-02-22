import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            StringTokenizer two = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(two.nextToken());
            int b = Integer.parseInt(two.nextToken());
            if(a==0) break;
            bw.write(a>b?"Yes" : "No");
            bw.write("\n");
        }
        bw.flush();
    }
}
