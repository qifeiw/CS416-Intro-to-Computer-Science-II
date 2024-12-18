import java.util.Scanner;
/**
 * @author Qifei Wang
 * @version 1.0
 */

public class ReadingScore {
    /**
    *
    * @param args default arguments
    */
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String text = sca.nextLine();
        int calculatedScore = getReadingScore(text);
        System.out.println(calculatedScore);
        if (calculatedScore >= 0 && calculatedScore <= 10) {
            System.out.println("Extremely difficult to read.");
        } else if (calculatedScore <= 30) {
            System.out.println("Very difficult to read.");
        } else if (calculatedScore <= 50) {
            System.out.println("Difficult to read.");
        } else if (calculatedScore <= 60) {
            System.out.println("Fairly difficult to read.");
        } else if (calculatedScore <= 70) {
            System.out.println("Plain English.");
        } else if (calculatedScore <= 80) {
            System.out.println("Fairly easy to read.");
        } else if (calculatedScore <= 90) {
            System.out.println("Easy to read.");
        } else {
            System.out.println("Very easy to read.");
        }
    }
    /**
     * 
    * @param token the token to be formated
     * @return A string with only the letter characters from original input
     */

    public static String formatToken(String token) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    } 
    /**
     * 
     * @param text The text to be tokenized.
     * @return Any array of words.
     */

    public static String[] tokenize(String text) {

        /**
         * tokenize the text
         */

        return text.split("\\s+");

    }
    /**
     * 
     * @param tokens The array of tokens.
     * @return The length of the array.
     */

    public static int getSentenceCount(String[] tokens) {

        /**
         * count the sentences number of tokens
         */

        int counter = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                char lastCharacter = token.charAt(token.length() - 1);
                if (lastCharacter == '.' || lastCharacter == ':' || lastCharacter == ';' 
                    || lastCharacter == '?' || lastCharacter == '!') {
                    counter++;
                }
            }
        }
        return counter;
    }
    /**
     * 
     * @param tokens The array of tokens.
     * @return The length of the array.
     */

    public static int getTokenCount(String[] tokens) {
        /**
         * get length of tokens
         */
        return tokens.length;
    }
    /**
     * 
     * @param word The word whose syllable count is to be calculated.
     * @return The syllable count of the word.
     */

    public static int getSyllableCount(String word) {
        /**
         * get syllable numbers of string
         */
        int syllableCount = 0;
        //String word = tokenize(inputWord);
        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                if (isVowel(word.charAt(i))) {
                    syllableCount++;
                }
            }
            //if (word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E') {
            //    syllableCount--;
            //}
            if (word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E') {
                if (syllableCount >= 1) {
                    syllableCount--;
                }
            }
            if (syllableCount < 1) {
                syllableCount = 1;
            }
        } 
        return syllableCount; 
    }
    /**
     * 
     * @param c The character to be checked.
     * @return True if the character is a vowel, false otherwise.
     */

    private static boolean isVowel(char c) {

        /**
         * check whether a char is vowel
         */
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }
    /**
     * 
     * @param tokens The array of tokens.
     * @return The total syllable count.
     */

    public static double getTotalSyllableCount(String[] tokens) {

        /**
         * get total syllablecount of array
         */
        int totalSyllable = 0;
        for (String token : tokens) {
            totalSyllable += getSyllableCount(token);
        }
        return totalSyllable * 0.88;
    }
    /**
     * 
     * @param text The text whose reading score is to be calculated.
     * @return The calculated reading score.
     */
    
    public static int getReadingScore(String text) {
        /**
         * calculate the reading score
         */
        String[] txt = tokenize(text);
        int tokenNumbers = getTokenCount(txt);
        int sentenceNumbers = getSentenceCount(txt);
        double syllableNumbers = getTotalSyllableCount(txt);
        double score = 206.835 - 1.015 * (tokenNumbers / sentenceNumbers) - 84.6 * (syllableNumbers / tokenNumbers);
        int roundedScore = (int) Math.round(score);
        if (roundedScore >= 100) {
            roundedScore = 100;
        }
        return roundedScore;
    }
}
