package dynamic;

/**
 * @author : Alexander Serebriyan
 */
public class SentenceScreenFitting {

    public static void main(String[] args) {

        final long start = System.currentTimeMillis();
        System.out.println(wordsTyping(new String[] {"I", "had", "apple", "pie"}, 20000, 20000));
        System.out.println(System.currentTimeMillis() - start);
    }


    public static int wordsTyping(String[] sentence, int rows, int cols) {

        int res = 0;
        int currentRow = 0;

        int currentWordIndex = 0;
        int currentLineLength = 0;

        int sentenceLength = sentence.length;

        for (String s : sentence) {
            sentenceLength += s.length();
        }

        while (currentRow <= rows-1) {

            if (currentLineLength == 0) {
                final int numberOfFits = cols / sentenceLength;
                if(numberOfFits > 0) {
                    currentLineLength += numberOfFits * sentenceLength;
                    res += numberOfFits;
                }
            }

            final int wordRequiredSpace  = sentence[currentWordIndex].length();

            if (cols - currentLineLength >= wordRequiredSpace) {
                currentLineLength += wordRequiredSpace + 1;

//                System.out.print(sentence[currentWordIndex] + "-");
                currentWordIndex ++;
            } else {
                currentLineLength = 0;
                currentRow++;
//                System.out.print("\n");
            }

            if(currentWordIndex >= sentence.length) {
                currentWordIndex = 0;
                res ++;
            }

        }

        return res;
    }
}
