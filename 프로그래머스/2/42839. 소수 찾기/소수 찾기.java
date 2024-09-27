import java.util.*;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];
        boolean[] check = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            nums[i]=numbers.charAt(i)-'0';
        }
        for(int i=1; i<=nums.length; i++){
            dfs(nums, i, check, 0, 0);
        }
        return primes.size();
    }
    public void dfs(int[] nums, int len, boolean[] check, int cnt, int num){
        if(cnt==len&&isPrime(num)){
            primes.add(num);
        }
        
        for(int i=0; i<nums.length; i++){
            if(!check[i]){
                check[i]= true;
                dfs(nums, len, check, cnt+1, num*10+nums[i]);
                check[i]= false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}