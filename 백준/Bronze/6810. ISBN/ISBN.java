import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 91;
        for(int i=0; i<3; i++){
            int tmp = Integer.parseInt(br.readLine());
            sum+=tmp*(i%2==0?1:3);
        }

        System.out.println("The 1-3-sum is "+sum);
    }
}
