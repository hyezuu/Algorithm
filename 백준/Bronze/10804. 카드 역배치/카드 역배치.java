import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int[][] nums = new int[10][2];
        for(int i=0; i<10; i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print(T.solution(nums));
    }
    public String solution(int[][] nums) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for(int[] num : nums){
           for(int i=0; i<20; i++){
               if(i>=(num[0]-1)&&i<(num[0])+(num[1]-num[0])/2){
                   int tmp=arr[num[0]+num[1]-i-2];
                   arr[num[0]+num[1]-i-2] = arr[i];
                   arr[i] = tmp;
               }
           }
        }
        for(int i=0; i<20; i++){
            sb.append(arr[i]).append(" ");
        }
        String str = sb.toString();
        return str.substring(0,str.length()-1);
    }
}
