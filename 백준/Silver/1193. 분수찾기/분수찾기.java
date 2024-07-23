import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        System.out.println(solution(X));
    }

    static String solution(int x) {
        int i=1;

        while(x>i) {
            x-=i;
            i++;
        }

        int deno = x;
        int mole = i+1-x;
        if(i%2!=0) return mole + "/" + deno;
        else return deno + "/" + mole;
    }
}