import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!str.startsWith("#")) {
            str = str.toLowerCase();
            char a = str.charAt(0);
            String s = str.substring(2);
            int cnt = 0;
            for(char c : s.toCharArray()) {
                if(a == c) {
                    cnt++;
                }
            }
            sb.append(a).append(" ").append(cnt);
            sb.append("\n");
            str = br.readLine();
        }

        System.out.print(sb);
    }
}