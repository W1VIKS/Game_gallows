import java.util.HashSet;
import java.util.Set;
public class HangmanGameState {
    private final String selectedWord;
    private final Set<Character> guessedLetters;
    private int errorCount;
    private static final int MAX_ERRORS = 6;

    public HangmanGameState(String selectedWord) {
        this.selectedWord = selectedWord;
        this.guessedLetters = new HashSet<>();
        this.errorCount = 0;
    }

    //проверка на победу
    public boolean isWin() {
        for (int i = 0; i < selectedWord.length(); i++) {
            char letter = selectedWord.charAt(i);
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    //проверка на проигрыш
    public boolean isGameOver() {
        return errorCount >= MAX_ERRORS;
    }

    public String getSelectedWord() {return selectedWord;}
    public Set<Character> getGuessedLetters() { return guessedLetters; }
    public int getErrorCount() { return errorCount; }



}
