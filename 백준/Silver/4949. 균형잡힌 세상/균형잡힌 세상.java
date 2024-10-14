import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String tmp = br.readLine();
            if(tmp.equals(".")) {
                break;
            }
            else sb.append(tmp);
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), ".");

        while(st.hasMoreTokens()) {
            bw.write(isValid(st.nextToken())? "yes": "no");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='['){
                stack.push(c);
            }
            else if(c==')' || c==']'){
                if(!stack.isEmpty() && ((c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='['))){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}