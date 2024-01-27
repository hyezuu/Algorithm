class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string);
        char[] a = {'a','e','i','o','u'};
        for(int i = 0; i<5; i++){
            while(my_string.indexOf(a[i])!= -1){
                sb.deleteCharAt(my_string.indexOf(a[i]));
                my_string = sb.toString();
            }
        }
        return my_string;
        
    }
}