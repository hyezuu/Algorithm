import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String stat = "";
        if(n%2==0) stat = "even";
        else stat = "odd";
        System.out.printf("%d is %s",n,stat);
    }
}