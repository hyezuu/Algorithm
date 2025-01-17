import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = "ABC";
        String B = "BABC";
        String G = "CCAABB";

        int len = Integer.parseInt(br.readLine());
        String answer = br.readLine();
        int c1 = 0, c2 = 0, c3 = 0;

        for(int i = 0; i < len; i++) {
            char c = answer.charAt(i);
            if(c == A.charAt(i%A.length())) {
                c1++;
            }
            if(c == B.charAt(i%B.length())) {
                c2++;
            }
            if(c == G.charAt(i%G.length())) {
                c3++;
            }
        }
        int max = Math.max(c1, Math.max(c2, c3));

        System.out.println(max);
        if(max==c1){
            System.out.println("Adrian");
        }
        if(max==c2){
            System.out.println("Bruno");
        }
        if(max==c3){
            System.out.println("Goran");
        }
    }
}