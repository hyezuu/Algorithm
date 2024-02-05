import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];

        for(int i=0; i<5; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.print(main.solution(nums));
    }

    public String solution(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[2];
        int avg = (int)Arrays.stream(nums).average().getAsDouble();

        return avg +"\n" +mid;
    }
}