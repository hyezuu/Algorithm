import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> map = new HashMap<>();

        for(String term : terms){
            map.put(term.charAt(0), Integer.parseInt(term.substring(2)));
        }

        List<Integer> list = new ArrayList<>();

        int idx = 1;

        for(String privacy : privacies){
            int addedDate = 28*(map.get(privacy.charAt(11)));

            int totalDate = getTotalDate(today);
            int expirationDate = getTotalDate(privacy) + addedDate;

            if(totalDate >= expirationDate){
                list.add(idx);
            }
            idx++;
        }

        return list;

    }

    private int getTotalDate(String day){
        int year = Integer.parseInt(day.substring(0, 4));
        int month = Integer.parseInt(day.substring(5, 7));
        int date = Integer.parseInt(day.substring(8, 10));
        
        return date + month*28 + (year-2000)*(28*12);
    }
}