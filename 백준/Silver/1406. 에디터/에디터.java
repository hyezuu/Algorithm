import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sl = new StringBuilder();
        StringBuilder sr = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackR = new Stack<>();

        for(int i=0; i<str.length(); i++){
            stackL.push(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            if (!stackL.isEmpty() && c == 'L') stackR.push(stackL.pop());
            else if (!stackL.isEmpty() && c == 'B') {
                stackL.pop();
            } else if (!stackR.isEmpty()&&c == 'D') stackL.push(stackR.pop());
            else if (c == 'P') {
                stackL.push(s.charAt(2));
            }
        }

        for(Character c : stackL){
            sl.append(c);
        }
        for(Character c : stackR){
            sr.append(c);
        }
        sr.reverse();
        sl.append(sr);

        bw.write(sl.toString());
        bw.flush();
    }
}
