import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int date = Integer.parseInt(today.substring(8, 10));
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(String term : terms){
            map.put(term.charAt(0), Integer.parseInt(term.substring(2)));
        }
        
        List<Integer> list = new ArrayList<>();
        
        int idx = 1;
        
        for(String privacy : privacies){
            int tempYear = Integer.parseInt(privacy.substring(0, 4));
            int tempMonth = Integer.parseInt(privacy.substring(5, 7));
            int tempDate = Integer.parseInt(privacy.substring(8, 10));
            
            int addedDate = 28*(map.get(privacy.charAt(11)));
            
            int totalDate = getTotalDate(year, month, date);
            int expirationDate = getTotalDate(tempYear, tempMonth, tempDate) + addedDate;
            
            if(totalDate >= expirationDate){
                list.add(idx);
            }
            idx++;
        }
        
        return list;
        
    }
    
    private int getTotalDate(int year, int month, int date){
        return date + month*28 + (year-2000)*(28*12);
    }
}