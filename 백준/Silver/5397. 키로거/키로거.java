import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stackL = new Stack<>();
            Stack<Character> stackR = new Stack<>();
            for (char c : str.toCharArray()) {
                if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                    stackL.push(c);
                }
                if (!stackL.isEmpty() && c == '<') stackR.push(stackL.pop());
                else if (!stackR.isEmpty() && c == '>') stackL.push(stackR.pop());
                else if (!stackL.isEmpty() && c == '-') stackL.pop();
            }
            while (!stackR.isEmpty()){
                stackL.push(stackR.pop());
            }
            for(char c : stackL){
                answer.append(c);
            }
            answer.append("\n");
        }
        bw.write(answer.substring(0,answer.length()));
        bw.flush();
    }
}
