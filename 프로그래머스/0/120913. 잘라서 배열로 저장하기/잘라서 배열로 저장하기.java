class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int size = 0;
        if(len%n==0){
            size = len/n;
        }
        else size= (int)len/n + 1;
        String str = ""; 
            for(int i=0; i<size; i++){
                if(i==size-1){
                    str += my_str.substring(i*n)+" ";
                }
                else str += my_str.substring(i*n, i*n+n)+" ";
            }
        
        return str.split(" ");
        }
    }
