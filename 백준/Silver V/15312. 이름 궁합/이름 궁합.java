import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public String solution(String me, String her, int len) {
        int answer =0;
        int[] arr ={3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        int[] sum1 = new int[len*2];

        for(int i=0; i<len; i++){
            sum1[i*2] = arr[me.charAt(i)-'A'];
            sum1[i*2+1] =arr[her.charAt(i)-'A'];
        }
        for(int i=0; i<sum1.length; i++){
//            System.out.print(sum1[i]+" ");
        }
//        System.out.println("  ");
        int cnt = sum1.length;
        while(cnt>2){
//            System.out.print(" ".repeat(sum1.length-cnt+1));
            for(int i=0; i<cnt-1; i++){
                sum1[i] = (sum1[i]+sum1[i+1])%10;
//                System.out.print(sum1[i]+" ");
            }
//            System.out.println("");
            cnt--;
        }

        return sum1[0]+""+sum1[1];
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String me = br.readLine();
        String her = br.readLine();
        int len = me.length();
        bw.write(T.solution(me, her, len));
        bw.flush();
    }
}
