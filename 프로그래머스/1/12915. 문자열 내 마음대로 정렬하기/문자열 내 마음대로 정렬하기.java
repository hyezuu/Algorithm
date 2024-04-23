class Solution {
    public String[] solution(String[] strings, int n) {
        int min = 27;

        for (int i = 0; i < strings.length; i++) {
            min = strings[i].charAt(n) - 'a';
            for (int j = i + 1; j < strings.length; j++) {
                int tn = strings[j].charAt(n) - 'a';
                String tmp = strings[i];
                if (min > tn) {
                    min = tn;
                    strings[i] = strings[j];
                    strings[j] = tmp;
                } else if (min == tn && tmp.compareTo(strings[j]) > 0) {
                    strings[i] = strings[j];
                    strings[j] = tmp;
                }
            }
        }
        return strings;
    }
}