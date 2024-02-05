import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print(main.solution(a,b));
    }
    public String solution(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int count = min==max? 0: max-min-1;
        String answer = "";
        for(int i=min+1; i<max ;i++){
            answer += i+" ";
        }
        answer = count + "\n" + answer;
        return answer.substring(0, answer.length()-1);
    }
}