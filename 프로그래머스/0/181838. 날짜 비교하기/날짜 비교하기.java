class Solution {
    public int solution(int[] date1, int[] date2) {  
        boolean flag = false;
        for(int i=0; i<3; i++){
            if(date1[i]==date2[i]) continue;
            
            return date2[i]>date1[i] ? 1 : 0;
        }
        
        return 0; 
        
//         int total1 = 0;
//         int total2 = 0;
//         int[] day = {360, 30, 1};
        
//         for(int i=0; i<3; i++){
//             total1+=date1[i]*day[i];
//             total2+=date2[i]*day[i];
//         }
//         return total1<total2 ? 1:0;
    }
}