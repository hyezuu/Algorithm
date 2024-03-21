import java.util.Stack;

class Solution {

    public static String solution(String a, String b) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        String tmp = "";

        int shortLen = Math.min(a.length(), b.length());
        int longLen = Math.max(a.length(), b.length());

        if (a.length() != b.length()) {
            if (shortLen == a.length()) {
                for (int i = shortLen; i < longLen; i++) {
                    tmp += "0";
                }
                a = tmp + a;
            } else {
                for (int i = shortLen; i < longLen; i++) {
                    tmp += "0";
                }
                b = tmp + b;
            }
        }

        boolean carry = false;
        int sumNum = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            int NumA = Integer.parseInt(String.valueOf(a.charAt(i)));
            int NumB = Integer.parseInt(String.valueOf(b.charAt(i)));

            if (carry) {
                sumNum = NumA + NumB + 1;
                carry = false;
            } else {
                sumNum = NumA + NumB;
            }

            if (sumNum >= 10) {
                carry = true;
                stack.push(sumNum - 10);
            } else {
                stack.push(sumNum);
            }
        }

        if (carry) {
            stack.push(1);
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}
