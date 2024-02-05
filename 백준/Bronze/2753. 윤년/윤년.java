import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int answer = 0;
        
        if((input%4==0&&input%100!=0)||input%400==0){
            answer = 1;
        }
        
        System.out.print(answer);
    }
  
}