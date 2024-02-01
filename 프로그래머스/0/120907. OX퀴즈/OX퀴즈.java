class Solution {
    public String[] solution(String[] quiz) {
        for(int i=0; i<quiz.length ; i++){
            String[] newQuiz = quiz[i].split(" ");
            
            int leftValue = Integer.parseInt(newQuiz[0].trim());
            int operator = newQuiz[1].equals("+")? 1: -1;
            int rightValue = Integer.parseInt(newQuiz[2].trim());
            int answerValue = Integer.parseInt(newQuiz[4].trim());
            
             
            quiz[i] = leftValue+(rightValue*operator) == answerValue ? "O" : "X" ; 
        }
        return quiz;
    }
}