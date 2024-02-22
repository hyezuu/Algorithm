import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            bw.write("Pairs for "+m+": ");
            int lt=1, rt= m-1;
            boolean isNotOnly = false;
            while (lt<rt){
                int sum = lt+rt;
                if(sum==m){
                    if(isNotOnly)bw.write(", ");
                    bw.write(lt+" "+rt);
                    lt++;
                    rt--;
                    isNotOnly = true;
                }
                else if(sum<m)lt++;
                else rt--;
            }
            bw.write("\n");
        }
        bw.flush();

    }
}
