import java.util.*;

class Solution {
    public long solution(String numbers) {
        String[] str 
            = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0 ; i<str.length ; i++){
            numbers = numbers.replaceAll(str[i], String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}