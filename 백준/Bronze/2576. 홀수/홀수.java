import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            nums[i] = scanner.nextInt();
            scanner.nextLine();
        }
        for(int i=0; i<main.solution(nums).size();i++){
            System.out.println(main.solution(nums).get(i));
        }
    }

    public List<Integer> solution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(0, -1);
        int sum = 0;
        int min = 99;
        for(int num : nums){
            if(num%2==1){
                sum+=num;
                list.set(0, sum);
                if(min>=num){
                    min = num;
                    if(list.size()==1){
                        list.add(1,min);
                    }
                    else list.set(1, min);
                }
            }
        }
        return list;
    }
}