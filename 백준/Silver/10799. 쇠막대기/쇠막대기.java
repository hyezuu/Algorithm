import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
        br.close();
    }

    private static int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c == '(') {
                stack.push(c);
            }
            else if(input.charAt(i-1) == '(') {
                stack.pop();
                cnt+=stack.size();
            }
            else {
                stack.pop();
                cnt++;
            }
        }
        return cnt;
    }
}
