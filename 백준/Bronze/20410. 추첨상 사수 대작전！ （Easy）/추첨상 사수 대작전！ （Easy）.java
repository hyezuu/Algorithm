import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        boolean flag = false;

        for(int a= 0; a<100; a++){
            for(int c = 0; c <100; c++){
                if((a*seed+c)%m == x1 && ((a*x1+c)%m ==x2)) {
                    System.out.print(a + " " + c);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
    }

}
