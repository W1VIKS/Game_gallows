public class HangmanGameRenderer {

    // ASCII-картинки для каждого этапа ошибок (от 0 до 6)
    private static final String[] GALLOWS = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========", // 0 ошибок
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========", // 1 ошибка
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========", // 2 ошибки
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========", // 3 ошибки
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========", // 4 ошибки
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========", // 5 ошибок
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="  // 6 ошибок (финал)
    };

    public void render(HangmanGameState state) {
        // 1. Рисуем виселицу.

        int errors = state.getErrorCount();
        System.out.println(GALLOWS[errors]);

        // 2. Выводим зашифрованное слово.
        String secretWord = state.getSelectedWord();
        StringBuilder wordView = new StringBuilder();

        for (int i = 0; i < secretWord.length(); i++) {
            char letter = secretWord.charAt(i);

            if (state.getGuessedLetters().contains(letter)) {
                wordView.append(letter);
            } else {
                wordView.append('_');
            }

            wordView.append(' ');
        }


        System.out.println("Слово: " + wordView.toString());
        System.out.println("Ошибки: " + errors + " из 6");
        System.out.println("Использованные буквы: " + state.getGuessedLetters());
        System.out.println("-----------------------------");
    }
}