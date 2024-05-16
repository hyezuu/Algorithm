import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(main.solution(n));
    }

    public int solution(int n) {
        n = n==1 ? 2 : n;
        for(int i=n;; i++){
            StringBuilder sb = new StringBuilder(i+"");
            if(sb.reverse().toString().equals(i+"")){
                boolean chk = true;
                for(int j=2; j<=Math.sqrt(i); j++){
                    if(i%j==0) {
                        chk = false;
                        break;
                    }
                }
                if(chk) return i;
            }
        }
    }

}