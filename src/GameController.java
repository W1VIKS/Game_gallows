import java.util.Scanner;

public class GameController {
    private final WordRepository wordRepository = new WordRepository();
    private final HangmanGameRenderer renderer = new HangmanGameRenderer();
    private final Scanner scanner = new Scanner(System.in);

    public void startNewGame() {
        // 1. Берем случайное слово из репозитория
        String secretWord = wordRepository.getRandomWord();

        // 2. Создаем новое состояние игры для этого раунда
        HangmanGameState state = new HangmanGameState(secretWord);

        System.out.println("Игра началась! Загадано слово из " + secretWord.length() + " букв.");

        // 3. Основной игровой цикл

        while (!state.isWin() && !state.isGameOver()) {

            // Отрисовываем текущее состояние виселицы и слова
            renderer.render(state);

            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();



            // Проверка 1: Ввели ли ровно один символ?
            if (input.length() != 1) {
                System.out.println("Ошибка! Нужно ввести ровно ОДНУ букву.");
                continue;
            }

            char letter = input.charAt(0);

            // Проверка 2: Является ли символ русской буквой?

            if (!(letter >= 'а' && letter <= 'я') && letter != 'ё') {
                System.out.println("Ошибка! Пожалуйста, используйте только русские буквы.");
                continue;
            }

            // Проверка 3: Вводилась ли эта буква ранее?
            if (state.getGuessedLetters().contains(letter)) {
                System.out.println("Вы уже вводили букву '" + letter + "'!");
                continue;
            }


            boolean hit = state.inputLetter(letter);

            if (hit) {
                System.out.println("Отлично! Есть такая буква.");
            } else {
                System.out.println("Увы, такой буквы нет.");
            }
        }

        // 4. Финал игры (вышли из цикла, значит кто-то победил или проиграл)
        renderer.render(state);

        if (state.isWin()) {
            System.out.println("🎉 ПОЗДРАВЛЯЕМ! Вы победили! Было загадано слово: " + state.getSelectedWord().toUpperCase());
        } else {
            System.out.println("💀 ИГРА ОКОНЧЕНА! Вас повесили. Загаданное слово было: " + state.getSelectedWord().toUpperCase());
        }
    }
}