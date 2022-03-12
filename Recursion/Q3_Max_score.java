import java.util.*;
public class Q3_Max_score {
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx == words.length) return 0;

        // if we are not including the word then the score
        int scoreNo = solution(words, farr, score, idx + 1);

        // if we are including the word then
        int sword = 0; // score of word
        boolean flag = true; // this will help us to calculate the score for yes
        String word = words[idx]; // using this we get our word present at idx
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(farr[ch - 'a'] == 0) flag = false; // check that the ch freq is present or not
            farr[ch - 'a']--; // decrease it's freq and adding the score for the particular char
            sword += score[ch - 'a'];
        }

        int scoreYes = 0;
        // if flag is true then only add the word score with solution()
        if(flag) scoreYes = sword + solution(words, farr, score, idx + 1);

        // backtracking so we can search for other subset
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }
    
        return Math.max(scoreYes, scoreNo);
      }
    
      public static void main(String[] args) {
    
        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0 ; i < words.length; i++) {
          words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
          letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
          score[i] = scn.nextInt();
        }
        scn.close();
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
            || score.length == 0) {
          System.out.println(0);
          return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
          farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));
    
      }
}
