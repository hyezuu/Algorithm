import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=n ; i>=1; i--){
            bw.write(" ".repeat(n-i));
            bw.write("*".repeat(2*i-1));
            bw.write("\n");
        }
        for(int i=2 ; i<=n; i++){
            bw.write(" ".repeat(n-i));
            bw.write("*".repeat(2*i-1));
            bw.write("\n");
        }
        bw.flush();
    }
}
